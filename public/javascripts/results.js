$(function() {

	var $container = $('#container');

	$container.isotope({
		itemSelector : '.element',
		layoutMode : 'masonry',
		getSortData : {
			resultType : function($elem) {
				return $elem.attr('data-resultType');
			},
			ranking : function($elem) {
				return parseInt($elem.find('.ranking').text(), 10);
			},
			name : function($elem) {
				return $elem.find('.name').text();
			}
		}
	});
	
	var $sortBy = $('#sort-by');
	$('#shuffle a').click(function() {
		$container.isotope('shuffle');
		$sortBy.find('.selected').removeClass('selected');
		$sortBy.find('[data-option-value="random"]').addClass('selected');
		return false;
	});
	
    // change layout
    var isHorizontal = false;
    function changeLayoutMode( $link, options ) {
      var wasHorizontal = isHorizontal;
      isHorizontal = $link.hasClass('horizontal');

      if ( wasHorizontal !== isHorizontal ) {
        // orientation change
        // need to do some clean up for transitions and sizes
        var style = isHorizontal ? 
          { height: '80%', width: $container.width() } : 
          { width: 'auto' };
        // stop any animation on container height / width
        $container.filter(':animated').stop();
        // disable transition, apply revised style
        $container.addClass('no-transition').css( style );
        setTimeout(function(){
          $container.removeClass('no-transition').isotope( options );
        }, 100 )
      } else {
        $container.isotope( options );
      }
    }

	// Optionset
	var $optionSets = $('#options .option-set'), $optionLinks = $optionSets
			.find('a');

	$optionLinks
			.click(function() {
				var $this = $(this);
				// don't proceed if already selected
				if ($this.hasClass('selected')) {
					return false;
				}
				var $optionSet = $this.parents('.option-set');
				$optionSet.find('.selected').removeClass('selected');
				$this.addClass('selected');

				// make option object dynamically, i.e. { filter:
				// '.my-filter-class' }
				var options = {}, key = $optionSet.attr('data-option-key'), value = $this
						.attr('data-option-value');
				// parse 'false' as false boolean
				value = value === 'false' ? false : value;
				options[key] = value;
				if (key === 'layoutMode'
						&& typeof changeLayoutMode === 'function') {
					// changes in layout modes need extra logic
					changeLayoutMode($this, options)
				} else {
					// otherwise, apply new options
					$container.isotope(options);
				}

				return false;
			});

	// change size of clicked element
	$container.delegate('.element', 'click', function() {
		$(this).toggleClass('large');
		$container.isotope('reLayout');
	});

});
