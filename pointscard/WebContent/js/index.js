$('#advs').cycle({
		    fx:    'fade',
		    prev:   '#leftNav', 
		    next:   '#rightNav',
		    pager:  '#advsNav',
		    timeout:     3000,
		    fastOnEvent: true,
		    slideExpr: '.advs',
		    pagerEvent: 'mouseover',
		    after: showNowAdvNav,
		    pagerAnchorBuilder: function(idx, slide) {
		        var filename = sprintf(2, (idx+1));
		        if(idx == 0){
		            return '<a><img src="imgs/num'+ filename +'_gray.png" border="0" id="advNavImg'+ (idx+1) +'" /></a>';
		        }else{
		            return '<a><img src="imgs/num'+ filename +'.png" border="0" id="advNavImg'+ (idx+1) +'" /></a>';
		        }
		    }
		

		});
		$('#advs_net').cycle({
		    fx:    'fade',
		    prev:   '#left_nav', 
		    next:   '#right_nav',
		    pager:  '#advs_nav',
		    timeout:     3000,
		    fastOnEvent: true,
		    slideExpr: '.advs',
		    pagerEvent: 'mouseover',
		    after: showNowAdvNavNet,
		    pagerAnchorBuilder: function(idx, slide) {
		        var filename = sprintf(2, (idx+1));
		        if(idx == 0){
		            return '<a><img src="../imgs/num'+ filename +'_gray.png" border="0" id="advNavImg'+ (idx+1) +'" /></a>';
		        }else{
		            return '<a><img src="../imgs/num'+ filename +'.png" border="0" id="advNavImg'+ (idx+1) +'" /></a>';
		        }
		    }

		});
		    $("#advsNav").css("opacity", "0.85");
		    
		var lastAdv = 1;
		function showNowAdvNav(){
		    if(lastAdv > 0){
		        //將上一個換圖回來
		        var lastAdvFilename = sprintf(2, lastAdv);
		        $("#advNavImg" + lastAdv).attr("src", 'imgs/num'+ lastAdvFilename +'.png');
		    }
		    lastAdv = $(this).attr("id").replace("adv_", "");
		    var nowAdvFilename =  sprintf(2, lastAdv);
		    $("a.activeSlide > img").attr("src", 'imgs/num'+ nowAdvFilename +'_gray.png');
		}
		function showNowAdvNavNet(){
		    if(lastAdv > 0){
		        //將上一個換圖回來
		        var lastAdvFilename = sprintf(2, lastAdv);
		        $("#advNavImg" + lastAdv).attr("src", '../imgs/num'+ lastAdvFilename +'.png');
		    }
		    lastAdv = $(this).attr("id").replace("adv_", "");
		    var nowAdvFilename =  sprintf(2, lastAdv);
		    $("a.activeSlide > img").attr("src", '../imgs/num'+ nowAdvFilename +'_gray.png');
		}

		function sprintf(checkLength, checkNumber){

		    var numberToString = checkNumber.toString();
		    var number = checkLength - numberToString.length;
		    var resultNumber = checkNumber;

		    for(var i=0; i< number; i++){
		            resultNumber = "0" + resultNumber;
		    }

		    return resultNumber;
		}



