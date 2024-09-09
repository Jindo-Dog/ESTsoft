package chap06.annotation;

@AnnotationName(elementNameOne = "값", elementNameTwo = 3)
public class ClassName {
	@AnnotationName(elementNameOne = "값")
	int field;

	int getField() {    // @Getter (롬복)
		return field;
	}

	void setField(int field) {        // @Setter (롬복)
		this.field = field;
	}

	@AnnotationName(elementNameOne = "값")
	public void method() {

	}
}
