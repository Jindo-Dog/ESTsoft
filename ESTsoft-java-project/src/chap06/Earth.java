package chap06;

public class Earth {
	static final double EARTH_RADIUS = 6400; // 지구의 반지름
	static final double EARTH_SURFACE_AREA; // 지구의 표면적

	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
}
