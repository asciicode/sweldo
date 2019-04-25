package com.atzkarl.framework.base.validation;

import com.atzkarl.framework.base.dto.BaseDTO;

public interface ValidationService {

    <D extends BaseDTO> void validate(D dto);
}
