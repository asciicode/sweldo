package com.atzkarl.framework.base.dozer.spring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

public class DozerBeanMapperFactoryBean extends
        org.dozer.spring.DozerBeanMapperFactoryBean {

    private final Logger logger = LoggerFactory
            .getLogger(DozerBeanMapperFactoryBean.class);

    /**
     * Forces the initialization of Dozer mappings.
     */
    public void init() {
        try {
            DozerBeanMapper mapper = (DozerBeanMapper) getObject();
            for (BeanMappingBuilder beanMappingBuilder : getBeanMappingBuilders()) {
                mapper.addMapping(beanMappingBuilder);
            }
            mapper.getMappingMetadata();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    protected List<BeanMappingBuilder> getBeanMappingBuilders() {
        List<BeanMappingBuilder> beanMappingBuilders = new ArrayList<>();
        for (final Class<?> dtoClass : getDTOClasses()) {
            final Class<?> modelClass = getModelClass(dtoClass);
            if (modelClass != null) {
                beanMappingBuilders.add(new BeanMappingBuilder() {

                    @Override
                    protected void configure() {
                        mapping(dtoClass, modelClass);
                    }
                });
                logger.debug("Added Dozer mapping for [{}, {}]",
                        dtoClass.getName(), modelClass.getName());
            }
            final Class<?> entityClass = getEntityClass(dtoClass);
            if (entityClass != null) {
                beanMappingBuilders.add(new BeanMappingBuilder() {

                    @Override
                    protected void configure() {
                        mapping(dtoClass, entityClass);
                    }
                });
                logger.debug("Added Dozer mapping for [{}, {}]",
                        dtoClass.getName(), entityClass.getName());
            }
        }
        return beanMappingBuilders;
    }

    protected Class<?> getModelClass(Class<?> dtoClass) {
        String modelClassName = dtoClass.getName()
                .replaceFirst(".dto.", ".rest.model.")
                .replaceFirst("DTO$", "Model");
        Class<?> modelClass = null;
        try {
            modelClass = ClassUtils.forName(modelClassName, getClass()
                    .getClassLoader());
        } catch (ClassNotFoundException e) {
            logger.trace("Ignored exception", e);
        }
        return modelClass;
    }

    protected Class<?> getEntityClass(Class<?> dtoClass) {
        String entityClassName = dtoClass.getName()
                .replaceFirst(".dto.", ".entity.").replaceFirst("DTO$", "");
        Class<?> entityClass = null;
        try {
            entityClass = ClassUtils.forName(entityClassName, getClass()
                    .getClassLoader());
        } catch (ClassNotFoundException e) {
            logger.trace("Ignored exception", e);
        }
        return entityClass;
    }

    protected List<Class<?>> getDTOClasses() {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resourcePatternResolver
					.getResources("classpath*:com/atzkarl/**/*DTO.class");
            MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(
                    resourcePatternResolver);
            List<Class<?>> dtoClasses = new ArrayList<>();
            for (Resource resource : resources) {
                MetadataReader metadataReader = metadataReaderFactory
                        .getMetadataReader(resource);
                ClassMetadata classMetadata = metadataReader.getClassMetadata();
                if (!classMetadata.getClassName().startsWith(
                        "com.atzkarl.framework")
                        && !classMetadata.isAbstract()
                        && !classMetadata.isInterface()) {
                    dtoClasses.add(ClassUtils.forName(classMetadata
                            .getClassName(), getClass().getClassLoader()));
                }
            }
            return dtoClasses;
        } catch (ClassNotFoundException | IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
