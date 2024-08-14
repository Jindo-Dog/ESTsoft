console.log('hello');

let p = new Promise((resolve, reject) => {
	resolve('hello world');		// 성공
	// reject('hello world');		// 실패
}).then((메시지) => {
	alert(메시지);	// hello world
	return 메시지.split(' ')[0];
}).then((메시지) => {
	alert(메시지);	// hello
	return 메시지[0];
}).then((메시지) => {
	alert(메시지);	// h
}).catch((메시지) => {
	alert('catch 실행!! :' + 메시지);	// catch 실행!! :hello world
});

console.log('world');