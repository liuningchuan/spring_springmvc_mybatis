package com.liuning.common.util;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 校验工具类
 *
 * @author liuning
 * @date 2020-05-26 23:19
 */
public class ValidationUtils {

    /**
     * 使用hibernate校验
     */
    private static final Validator validator = Validation.byProvider(HibernateValidator.class)
            .configure().failFast(true).buildValidatorFactory().getValidator();

    /**
     * 参数校验
     *
     * @param obj 需要校验的对象
     * @param <T> 对象类型
     */
    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constrainViolations = validator.validate(obj);
        if (constrainViolations.size() > 0) {
            throw new RuntimeException("参数校验失败");
        }
    }

    /**
     * 参数校验
     *
     * @param obj 需要校验的对象
     * @param groups 分组校验规则
     * @param <T> 对象类型
     */
    public static <T> void validate(T obj, Class<?>... groups) {
        Set<ConstraintViolation<T>> constrainViolations = validator.validate(obj, groups);
        if (constrainViolations.size() > 0) {
            throw new RuntimeException("参数校验失败");
        }
    }
}
