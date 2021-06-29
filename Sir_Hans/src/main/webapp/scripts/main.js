class MessageManager {
	static String contents;
	static long vote;
	static String author;
    
    static addLayer(layer) {
        LeafletManager.discussion.addLayer(layer);
    }

    static removeLayer(layer) {
        LeafletManager.discussion.removeLayer(layer);
    }

}


function hideButtons() {
    $("#buttons button").css("visibility", "hidden");
    /*Opacity for a smoother transition */
    $("#buttons button").css("opacity", "0");
    /*$(".hide").css("z-index", "600");*/
}

function showButtons() {
    $("#buttons button").css("visibility", "visible");
    /*Opacity for a smoother transition */
    $("#buttons button").css("opacity", "1");
    /*$(".hide").css("z-index","0");*/
}



function hideOverlay() {
    $(".overlay").css("visibility", "hidden");
    $(".overlay .PopupMenu").css("visibility", "hidden");
    $(".overlay .small-modal").css("visibility", "hidden");
    $(".overlay").css("opacity", "0");
    $(".overlay .PopupMenu").css("opacity", "0");
    $(".overlay .PopupMenu").css("top", "-50%");
    $(".overlay .small-modal").css("opacity", "0");
    $(".overlay .small-modal").css("top", "-50%");
    $("#user-list").text("");
    showButtons();

    LeafletManager.discussion.off('click');
}

function showOverlay() {

    $(".overlay").css("visibility", "visible");
    $(".overlay").css("opacity", "1");
    $(".overlay .PopupMenu").css("opacity", "1");
    $(".overlay .PopupMenu").css("top", "10%");
}

function showSmallModal(){
    $(".overlay .small-modal").css("opacity", "1");
    $(".overlay .small-modal").css("top", "20%");   
    $(".small-modal").css("visibility", "visible"); 
}



function openSlidingPanel(direction,id) {
    $(id).css(direction, -50);
}

function closeSlidingPanel(direction,id) {
    $(id).css(direction, -400)
}




class DiscussionManager {

    /**
     * A discussion which contains messages
     *
     */
     
     static List<Message> message;
     
    