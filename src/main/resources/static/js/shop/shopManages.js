$(function () {

    var shopId = getQueryString('shopId');
    
    var shopUrl = '/shopAdmin/getShopManageInfo?shopId='+shopId;

    $.getJSON(shopUrl,function(data){

        if (data.redirect){

            window.location.href=data.url;

        }else {

            if (data.shopId!=null && data.shopId != undefined){

                shopId = data.shopId;

            }

            $('#shopInfo').attr('href','/shopAdmin/shopOpera?shopId='+shopId);

            $('#shopCategoryManage').attr('href','/shopAdmin/shopManageCategory?shopId='+shopId);

            $('#shopInfo').attr('href','/shopAdmin/shopOpera?shopId='+shopId);

        }

    });


});