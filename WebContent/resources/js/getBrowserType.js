	function getBrowserType() {
		if (navigator.userAgent.indexOf("MSIE") > 0) {
			return "MSIE";
		}
		if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
			return "Firefox";
		}
		if (isSafari = navigator.userAgent.indexOf("Safari") > 0) {
			return "Safari";
		}
		if (isCamino = navigator.userAgent.indexOf("Camino") > 0) {
			return "Camino";
		}
		if (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {
			return "Gecko";
		}
	}
    var sa = getBrowserType();
     window.onload = init;
    	 function init (){	
             document.getElementById("browserType").innerHTML="您正在使用类型为: "+sa+" 的浏览器浏览本站 ";
         }