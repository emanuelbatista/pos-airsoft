/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.dominio.validation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Responsável pela validação de entidades
 * @author emanuel
 */
public class Validacao {

    /**
     * Valida uma determinada entidade de acordo as anotação do <b>Hibernate Validation</b>
     * @param <T> Classe que será validada
     * @param t Objeto que será validado
     * @param grupos grupo de validação que será utilizado na validação
     * @return List de Violações das validação da entidade
     */
    public static <T> List<ConstraintViolation<T>> validar(T t, Class... grupos) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, grupos);
        return constraintViolations.parallelStream().collect(Collectors.toList());
    }
}
