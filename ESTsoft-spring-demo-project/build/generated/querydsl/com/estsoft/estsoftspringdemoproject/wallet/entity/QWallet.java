package com.estsoft.estsoftspringdemoproject.wallet.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWallet is a Querydsl query type for Wallet
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWallet extends EntityPathBase<Wallet> {

    private static final long serialVersionUID = -1609207879L;

    public static final QWallet wallet = new QWallet("wallet");

    public final QWalletEntityObject _super = new QWalletEntityObject(this);

    public final CollectionPath<Account, QAccount> accounts = this.<Account, QAccount>createCollection("accounts", Account.class, QAccount.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final MapPath<String, String, StringPath> metadata = _super.metadata;

    public final NumberPath<Long> totalBalance = createNumber("totalBalance", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final StringPath userId = createString("userId");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QWallet(String variable) {
        super(Wallet.class, forVariable(variable));
    }

    public QWallet(Path<? extends Wallet> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWallet(PathMetadata metadata) {
        super(Wallet.class, metadata);
    }

}

