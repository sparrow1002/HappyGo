$(function() {
		// 幫 #menu li 加上 hover 事件
		$('#menus>li').hover(
				function() {
					// 先找到 li 中的子選單
					var _this = $(this), _subnav = _this.children('ul');

					// 變更目前母選項的背景顏色
					// 同時滑入子選單(如果有的話)
					_this.css('backgroundColor', '#CC0000 ');
					_this.css('color', ' #A42D00');
					_subnav.stop(true, true).slideDown(400);
				},
				function() {
					// 變更目前母選項的背景顏色
					// 同時滑出子選單(如果有的話)
					// 也可以把整句拆成上面的寫法
					$(this).css('backgroundColor', '').children('ul').stop(
							true, true).slideUp(400);
				});

		// 取消超連結的虛線框
		$('a').focus(function() {
			this.blur();
		});
	});