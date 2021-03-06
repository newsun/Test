/*!
 * jquery.scrollLoading.js
 * by zhangxinxu  http://www.zhangxinxu.com
 * 2010-11-19 v1.0
 * 2012-01-13 v1.1 Ã¥ï¿½ï¿½Ã§Â§Â»Ã¥â‚¬Â¼Ã¨Â®Â¡Ã§Â®â€”Ã¤Â¿Â®Ã¦â€�Â¹ position Ã¢â€ â€™ offset
 */
(function($) {
	$.fn.scrollLoading = function(options) {
		var defaults = {
			attr : "data-url"
		};
		var params = $.extend({}, defaults, options || {});
		params.cache = [];
		$(this).each(
				function() {
					var node = this.nodeName.toLowerCase(), url = $(this).attr(
							params["attr"]);
					if (!url) {
						return;
					}
					// Ã©â€¡ï¿½Ã§Â»â€ž
					var data = {
						obj : $(this),
						tag : node,
						url : url
					};
					params.cache.push(data);
				});

		var loading = function() {
			var st = $(window).scrollTop(), sth = st + $(window).height();
			$.each(params.cache,
					function(i, data) {
						var o = data.obj, tag = data.tag, url = data.url;
						if (o) {
							post = o.offset().top;
							posb = post + o.height();
							if ((post > st && post < sth)
									|| (posb > st && posb < sth)) {
								if (tag === "img") {
									o.attr("src", url);
								} else {
									o.load(url);
								}
								data.obj = null;
							}
						}
					});
			return false;
		};

		loading();
		$(window).bind("scroll", loading);
	};
})(jQuery);