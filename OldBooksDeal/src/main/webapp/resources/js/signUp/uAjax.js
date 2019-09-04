uSample2 = function()
{
	console.log("sssaa");
}


uAjax = function(_type, _url , _data, _dataType, _success, _error)
{
	$.ajax(
			{
				type:_type, // 문자열
				url: _url, //  문자열
				data: _data, //파라미터, 문자열
				dataType: _dataType, // 결과데이터타입, 문자열
				success: _success, //함수. 인자 data,status,xhr
				error: _error //함수. 인자 data,status,xhr
			});
}