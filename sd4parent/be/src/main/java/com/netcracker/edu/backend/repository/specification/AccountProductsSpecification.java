package com.netcracker.edu.backend.repository.specification;

import com.netcracker.edu.backend.entity.AccountProducts;

import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountProductsSpecification {

    public static Specification<AccountProducts> subscriptionsFindByUserId(String login) {
        return new Specification<AccountProducts>() {
            @Override
            public Predicate toPredicate(Root<AccountProducts> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("account").get("user").get("login"), login);
            }
        };
    }

}