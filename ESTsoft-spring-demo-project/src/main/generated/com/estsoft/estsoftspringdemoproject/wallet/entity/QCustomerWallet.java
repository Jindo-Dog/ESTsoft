package com.estsoft.estsoftspringdemoproject.wallet.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomerWallet is a Querydsl query type for CustomerWallet
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerWallet extends EntityPathBase<CustomerWallet> {

    private static final long serialVersionUID = 133184823L;

    public static final QCustomerWallet customerWallet = new QCustomerWallet("customerWallet");

    public final QWallet _super = new QWallet(this);

    //inherited
    public final CollectionPath<Account, QAccount> accounts = _super.accounts;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final MapPath<String, String, StringPath> metadata = _super.metadata;

    //inherited
    public final NumberPath<Long> totalBalance = _super.totalBalance;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath userId = _super.userId;

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QCustomerWallet(String variable) {
        super(CustomerWallet.class, forVariable(variable));
    }

    public QCustomerWallet(Path<? extends CustomerWallet> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomerWallet(PathMetadata metadata) {
        super(CustomerWallet.class, metadata);
    }

}

