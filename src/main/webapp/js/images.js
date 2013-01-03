var ImgLoadManager = (function() {
	var storedInstance = null;

	var ImgLoad = function() {
		this.imgs = document.getElementsByTagName('img');
	};

	ImgLoad.prototype = {
		getPageSize : function() {
			var winH;
			if (window.innerHeight) {
				winH = window.innerHeight;
			} else if (document.documentElement
					&& document.documentElement.clientHeight) {
				winH = document.documentElement.clientHeight;
			} else if (document.body) {
				winH = document.body.clientHeight;
			}
			;
			return {
				WinH : winH
			};
		},

		getPageScroll : function() {
			var y;
			if (window.pageYOffset) {
				y = window.pageYOffset;
			} else if (document.documentElement
					&& document.documentElement.scrollTop) {
				y = document.documentElement.scrollTop;
			} else if (document.body) {
				y = document.body.scrollTop;
			}
			;
			return {
				Y : y
			};
		},

		getOffsetTop : function(el) {
			var t = el.offsetTop;
			while (el = el.offsetParent) {
				t += el.offsetTop;
			}
			;
			return t;
		},

		addEvent : function(el, type, fn) {
			if (window.addEventListener) {
				el.addEventListener(type, fn, false);
			} else if (window.attachEvent) {
				el.attachEvent('on' + type, fn);
			} else {
				el['on' + type] = fn;
			}
			;
		},

		removeEvent : function(el, type, fn) {
			if (window.removeEventListener) {
				el.removeEventListener(type, fn, false);
			} else if (window.detachEvent) {
				el.detachEvent('on' + type, fn);
			} else {
				el['on' + type] = null;
			}
			;
		},

		bubbleSort : function(array) {
			var i = 0, len = array.length, j, d;
			for (; i < len; i++) {
				for (j = 0; j < len; j++) {
					if (array[i] < array[j]) {
						d = array[j];
						array[j] = array[i];
						array[i] = d;
					}
					;
				}
				;
			}
			;
			return array;
		},

		resize : function() {
			this.pageHeight = this.getPageSize().WinH;
		},

		setOpacity : function(el, val) {
			var browserName = navigator.userAgent.toLowerCase();
			if (/msie/i.test(browserName) && !/opera/.test(browserName)) {
				el.style.filter = 'alpha(opacity=' + (val * 100) + ')';
			} else {
				el.style.opacity = val;
			}
			;
		},

		init : function() {
			this.json = {};
			this.sort = [];
			this.pageHeight = this.getPageSize().WinH;
			if (this.imgs != null) {
				for ( var i = 0, len = this.imgs.length; i < len; i++) {
					var img = this.imgs[i];
					var oImg = {
						'img' : img,
						'path' : img.getAttribute('path'),
						'offsetTop' : this.getOffsetTop(img)
					};
					img.removeAttribute('path');
					this.sort.push(oImg.offsetTop);
					this.json[oImg.offsetTop] = oImg;
				}
				;
				this.sort = this.bubbleSort(this.sort);
			}
			;
		},

		animate : function(el) {
			var that = this;
			var opacity = 0.1;
			setTimeout(function() {
				opacity += 0.1;
				that.setOpacity(el, opacity);
				if (opacity < 1) {
					setTimeout(arguments.callee, 100);
				}
				;
			}, 100);
		},

		startLoad : function() {
			var that = this;
			var img = [];
			var aImg = [];
			var num = 0;
			if (this.sort.length !== 0) {
				for ( var i = 0; i < this.sort.length; i++) {
					if (this.sort[i] < (this.pageHeight + this.getPageScroll().Y)) {
						num++;
						img[i] = new Image();
						aImg[i] = this.json[this.sort[i]].img;
						img[i].src = this.json[this.sort[i]].path;
						if (img[i].complete) {
							aImg[i].src = img[i].src;
						} else {
							img[i].onload = function(key) {
								return function() {
									aImg[key].style.background = '#fff';
									that.setOpacity(aImg[key], 0.1);
									aImg[key].src = this.src;
									that.animate(aImg[key]);

								}
							}(i);
						}
						;
					} else {
						break;
					}
					;
				}
				;

				if (num > 0) {
					for ( var i = num; i > 0; i--) {
						this.sort.splice(i - 1, 1);
					}
					;
					num = 0;
				}
				;
			} else {
				this.removeEvent(window, 'scroll', function() {
					this.startLoad();
				});
				this.imgs = null;
				this.pageWidth = null;
				this.pageHeight = null;
				this.json = null;
				return;
			}
			;

		}
	};

	return {

		appImgLoad : function() {
			var tt = this.getImgLoad();
			tt.init();
			tt.addEvent(window, 'load', function() {
				setTimeout(function() {
					tt.startLoad();
				}, 1000);
			});
			tt.addEvent(window, 'scroll', function() {
				tt.startLoad();
			});
			tt.addEvent(window, 'resize', function() {
				tt.resize();
			});
		},

		getImgLoad : function() {
			if (storedInstance == null) {
				storedInstance = new ImgLoad();
			}
			;
			return storedInstance;
		}
	};

})();
ImgLoadManager.appImgLoad();