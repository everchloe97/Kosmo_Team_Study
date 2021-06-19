const toggleBtn = document.querySelector('.navbar_toggleBtn');
const menu = document.querySelector('.navbar_menu');
const icons = document.querySelector('.navbar_icons');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    icons.classList.toggle('active');
});

var msnry = new Masonry( '.grid', {
    itemSelector: '.grid-item',
    // columnWidth: 200
    columnWidth: '.grid-sizer',
    percentPosition: true,
    gutter : 15,
    });
    imagesLoaded( '.grid' ).on( 'progress', function() {
    msnry.layout();
    });