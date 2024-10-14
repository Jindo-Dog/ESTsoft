package com.estsoft.estsoftspringdemoproject.wallet.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMerchantWallet is a Querydsl query type for MerchantWallet
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMerchantWallet extends EntityPathBase<MerchantWallet> {

    private static final long serialVersionUID = 1997008801L;

    public static final QMerchantWallet merchantWallet = new QMerchantWallet("merchantWallet");

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

    public QMerchantWallet(String variable) {
        super(MerchantWallet.class, forVariable(variable));
    }

    public QMerchantWallet(Path<? extends MerchantWallet> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMerchantWallet(PathMetadata metadata) {
        super(MerchantWallet.class, metadata);
    }

}

