fetch('https://test.api.weniv.co.kr/mall')
	.then((data) => data.json())
	.then((data) => {
		console.log(data);
	}) // 통신이 성공했을 때!
	.catch((error) => {
		console.log(error);
	}) // 통신이 실패했을 때!

///////////////////

fetch('https://test.api.weniv.co.kr/mall')
	.then((data) => data.json())
	.then((data) => {
		console.log(data);
		return data[0]
	}) // 통신이 성공했을 때!
	.then((data) => {
		console.log(data);	// return이 없으면 undefined
	})
	.catch((error) => {
		console.log(error);
	}) // 통신이 실패했을 때!

///////////////////

fetch('https://test.api.weniv.co.kr/mall')
	.then((data) => data.json())
	.then((data) => {
		console.log(data);
		return data[0]
	}) // 통신이 성공했을 때!
	.then((data) => {
		console.log(data);
		return 'hello'
	})
	.catch((error) => {
		console.log(error);
	}) // 통신이 실패했을 때!

////////////////////////////////////////////////

// 이 API는 30분마다 갱신되는 API입니다
// 중간에 초기화 되더라도 놀라지 마세요
// 저희 서버로 공격하지 마세요
fetch("https://eduapi.weniv.co.kr/404/blog")
	.then((response) => response.json())
	.then((json) => console.log(json))
	.catch((error) => console.error(error));

fetch("https://eduapi.weniv.co.kr/404/blog/1")
	.then((response) => response.json())
	.then((json) => console.log(json))
	.catch((error) => console.error(error));

fetch("https://eduapi.weniv.co.kr/404/blog", {
	method: "POST",
	headers: {
		"Content-Type": "application/json",
	},
	body: JSON.stringify({
		title: "test 404 !",
		content: "test 404 !",
	}),
})
	.then((response) => response.json())
	.then((json) => console.log(json))
	.catch((error) => console.error(error));

fetch("https://eduapi.weniv.co.kr/404/blog/1", {
	method: "PUT",
	headers: {
		"Content-Type": "application/json",
	},
	body: JSON.stringify({
		title: "test put !",
		content: "test put !",
	}),
})
	.then((response) => response.json())
	.then((json) => console.log(json))
	.catch((error) => console.error(error));

fetch("https://eduapi.weniv.co.kr/404/blog/2", {
	method: "PUT",
	headers: {
		"Content-Type": "application/json",
	},
	body: JSON.stringify({
		title: "!!!",
		content: "!!!",
	}),
})
	.then((response) => response.json())
	.then((json) => console.log(json))
	.catch((error) => console.error(error));

fetch("https://eduapi.weniv.co.kr/404/blog/1", {
	method: "DELETE",
})
	.then((response) => response.json())
	.then((json) => console.log(json))
	.catch((error) => console.error(error));