//top-nav / slide sidebar menu
function slideMenuHandler(e) {
  const slideOpenBtn = document.querySelector(".top-nav-modal");
  const slideCloseBtn = document.querySelector(".category-close");
  const slideMenu = document.querySelector(".top-nav-category");

  const target = e.target;
  const parentTarget = e.target.parentNode;
  const activetarget = e.currentTarget.document.activeElement;

  if (parentTarget === slideOpenBtn) {
    slideMenu.classList.add("open");
  } else if (activetarget === slideCloseBtn || target !== slideMenu) {
    slideMenu.classList.remove("open");
  }
}

window.addEventListener("click", slideMenuHandler);

//New Item / horizontal-scroll
function newItemWheel(e) {
  const newListBox = document.querySelector(".new-box");

  if (e.path[3] === newListBox) {
    document.body.classList.add("stop-scrolling");
    e.deltaY > 0
      ? (newListBox.scrollLeft += 40)
      : (newListBox.scrollLeft -= 40);
  } else {
    document.body.classList.remove("stop-scrolling");
  }
}

window.addEventListener("wheel", newItemWheel);

//top-nav / scroll detect
function scrollControll() {
  const topNav = document.querySelector(".top-nav");
  const topScroll = document.documentElement.scrollTop;
  topScroll
    ? topNav && topNav.classList.add("back-color")
    : topNav.classList.remove("back-color");
}

//header, footer markup data include
async function asyncMarkupData() {
  const allElements = document.getElementsByTagName("*");
  Array.prototype.forEach.call(allElements, function (el) {
    const includePath = el.dataset.includePath;
    if (includePath) {
      const xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          el.outerHTML = this.responseText;
        }
      };
      xhttp.open("GET", includePath, true);
      xhttp.send();
    }
  });
}

window.addEventListener("scroll", scrollControll);
