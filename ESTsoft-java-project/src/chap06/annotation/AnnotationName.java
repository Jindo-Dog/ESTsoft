package chap06.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface AnnotationName {
	String elementNameOne();

	int elementNameTwo() default 5;
}
