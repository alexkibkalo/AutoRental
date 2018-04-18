windows.onload = function () {
    // noinspection JSAnnotator
    location.reload() = function () {
        getCount();
    }
}
function getCount() {
    var request = new XMLHttpRequest();

    request.open('GET', '/app/reg_cer');
    request.send();
}