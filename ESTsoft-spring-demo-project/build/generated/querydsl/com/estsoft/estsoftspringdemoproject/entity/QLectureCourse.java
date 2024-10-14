package com.estsoft.estsoftspringdemoproject.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureCourse is a Querydsl query type for LectureCourse
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLectureCourse extends EntityPathBase<LectureCourse> {

    private static final long serialVersionUID = -118823752L;

    public static final QLectureCourse lectureCourse = new QLectureCourse("lectureCourse");

    public final NumberPath<Integer> capacity = createNumber("capacity", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath desc = createString("desc");

    public final DatePath<java.time.LocalDate> from = createDate("from", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> instructorId = createNumber("instructorId", Long.class);

    public final StringPath title = createString("title");

    public final DatePath<java.time.LocalDate> to = createDate("to", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QLectureCourse(String variable) {
        super(LectureCourse.class, forVariable(variable));
    }

    public QLectureCourse(Path<? extends LectureCourse> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureCourse(PathMetadata metadata) {
        super(LectureCourse.class, metadata);
    }

}

