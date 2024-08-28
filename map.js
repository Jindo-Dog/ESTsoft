// 카카오 맵 API
const script = document.createElement("script");
script.src = `https://dapi.kakao.com/v2/maps/sdk.js?appkey=985350c5816d259d8a69732b90d987ce&autoload=false&libraries=clusterer,services&`;
document.head.appendChild(script);
script.onload = () => {
	kakao.maps.load(() => {
		const node = document.querySelector('#map'); // 지도를 표시할 div
		const options = {
			center: new kakao.maps.LatLng(33.44227, 126.5715), // 지도의 중심좌표
			level: 3 // 지도의 확대 레벨
		};
		const map = new kakao.maps.Map(node, options);

		if (!window.matchMedia('(max-width: 768px)').matches) {
			// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
			const zoomControl = new kakao.maps.ZoomControl();
			map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
		}

		// 지도를 클릭한 위치에 표출할 마커입니다
		const marker = new kakao.maps.Marker({
			// 지도 중심좌표에 마커를 생성합니다
			position: map.getCenter()
		});
		// 지도에 마커를 표시합니다
		marker.setMap(map);
	});
};