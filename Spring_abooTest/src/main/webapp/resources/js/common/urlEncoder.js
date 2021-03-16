/**
 * data 라는 오브젝트를 받을 것임.
	date : urlEncode 방식으로 작성하고 싶은 데이터. 오브젝트
	parameter Name : 속성명
	parameter Value : 값
 */
let urlEncodeForm = data => {
	let arr = [];
for(key in data){
	let param = encodeURIComponent(key)+'='+encodeURIComponent(data[key]);
	arr.push(param);
}
return arr.join('&');
}
