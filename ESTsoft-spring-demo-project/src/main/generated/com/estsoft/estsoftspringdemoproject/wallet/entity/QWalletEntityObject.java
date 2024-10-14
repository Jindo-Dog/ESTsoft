package com.estsoft.estsoftspringdemoproject.wallet.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWalletEntityObject is a Querydsl query type for WalletEntityObject
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QWalletEntityObject extends EntityPathBase<WalletEntityObject> {

    private static final long serialVersionUID = -2099924133L;

    public static final QWalletEntityObject walletEntityObject = new QWalletEntityObject("walletEntityObject");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final MapPath<String, String, StringPath> metadata = this.<String, String, StringPath>createMap("metadata", String.class, String.class, StringPath.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QWalletEntityObject(String variable) {
        super(WalletEntityObject.class, forVariable(variable));
    }

    public QWalletEntityObject(Path<? extends WalletEntityObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWalletEntityObject(PathMetadata metadata) {
        super(WalletEntityObject.class, metadata);
    }

}

