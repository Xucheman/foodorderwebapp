package com.souraj.foodorder.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-27T14:48:32")
@StaticMetamodel(AbstractEntity.class)
public abstract class AbstractEntity_ { 

    public static volatile SingularAttribute<AbstractEntity, LocalDate> createdAt;
    public static volatile SingularAttribute<AbstractEntity, Long> id;
    public static volatile SingularAttribute<AbstractEntity, LocalDate> updatedAt;

}