package com.estsoft.estsoftspringdemoproject.wallet.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTransaction is a Querydsl query type for Transaction
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransaction extends EntityPathBase<Transaction> {

    private static final long serialVersionUID = 2139164446L;

    public static final QTransaction transaction = new QTransaction("transaction");

    public final QWalletEntityObject _super = new QWalletEntityObject(this);

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> dstAccountId = createNumber("dstAccountId", Long.class);

    public final EnumPath<AccountType> dstAccountType = createEnum("dstAccountType", AccountType.class);

    public final NumberPath<Long> dstAmount = createNumber("dstAmount", Long.class);

    public final NumberPath<Long> dstBalance = createNumber("dstBalance", Long.class);

    public final EnumPath<Currency> dstCurrency = createEnum("dstCurrency", Currency.class);

    public final StringPath dstUserId = createString("dstUserId");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final MapPath<String, String, StringPath> metadata = _super.metadata;

    public final NumberPath<Long> pid = createNumber("pid", Long.class);

    public final NumberPath<Long> srcAccountId = createNumber("srcAccountId", Long.class);

    public final EnumPath<AccountType> srcAccountType = createEnum("srcAccountType", AccountType.class);

    public final NumberPath<Long> srcAmount = createNumber("srcAmount", Long.class);

    public final NumberPath<Long> srcBalance = createNumber("srcBalance", Long.class);

    public final EnumPath<Currency> srcCurrency = createEnum("srcCurrency", Currency.class);

    public final StringPath srcUserId = createString("srcUserId");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QTransaction(String variable) {
        super(Transaction.class, forVariable(variable));
    }

    public QTransaction(Path<? extends Transaction> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTransaction(PathMetadata metadata) {
        super(Transaction.class, metadata);
    }

}

