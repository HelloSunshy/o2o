/*****
 * 店铺注册js
 */


$(function(){

    var shopId = getQueryString("shopId");

    var isEdit = shopId ? true : false;

    var initShopUrl = "/shopAdmin/shopInfo";

    var register = "/shopAdmin/registerShop";

    var shopInfoUrl = "/shopAdmin/queryShopById?shopId="+shopId;

    var editShopUrl = "/shopAdmin/modifyShop";

    if (isEdit){

        getShopInfo(shopId);

    } else {

        getInfo();

    }



    /***
     *
     * 获取地域和店铺类别信息
     *
     */
    function getInfo(){

        $.getJSON(initShopUrl,function(data){

            if (data.success){

                var tempHtml = " ";

                var tempAreaHtml = "";



                data.ShopCategoryList.map(function (item,index) {

                    tempHtml += '<option data-id = '+item.shopCategoryId+'>'+item.shopCategoryName+'</option>';





                });

                data.areaList.map(function (item, index) {

                    tempAreaHtml += '<option data-id = '+item.areaId+'>'+item.areaName+'</option>';

                });


                $('#shop-category').html(tempHtml);

                $('#area').html(tempAreaHtml);




            }

        });

    }


    function getShopInfo(shopId) {

        $.getJSON(shopInfoUrl,function(data){

            if (data.success){

                var  shop = data.shop;

                $('#shop-name').val(shop.shopName);

                $('#shop-addr').val(shop.shopAddr);

                $('#shop-desc').val(shop.shopDesc);

                $('#shop-phone').val(shop.phone);

                var category = '<option data-id="'+shop.shopCategory.shopCategoryId +'"selected>'

                    +shop.shopCategory.shopCategoryName + '</option>';

                var tempAreaHtml = "";

                data.areaList.map(function (item, index) {

                    tempAreaHtml += '<option data-id = '+item.areaId+'>'+item.areaName+'</option>';

                });

                $("#shop-category").html(category);

                // disabled 不能让用户选择
                $("#shop-category").attr('disabled','disabled');

                $("#area").html(tempAreaHtml);

                $("#area").attr('data-id',shop.areaId);
            }


        });




    }


    $('#submit').click(function(){

        var shop = {};

        if (isEdit){
            shop.shopId = shopId;
        }

        shop.shopName = $('#shop-name').val();


        shop.area ={ areaId:$('#area').find('option').not(function(){

                return !this.selected;

            }).data('id')};


        /**
         * 获取select中选中的option值
         * ***/
        shop.shopCategory ={ shopCategoryId:$('#shop-category').find('option').not(function(){

                return !this.selected;

            }).data('id')};

        var shopImage =  $('#shop-img')[0].files[0];

        shop.shopDesc = $('#shop-desc').val();

        shop.phone = $('#shop-phone').val();

        var  veFine = $('#j_captcha').val();

        var formatDate = new FormData();

        formatDate.append("shopStr",JSON.stringify(shop));

        formatDate.append("veFine",veFine);

        formatDate.append("shopImage",shopImage);


        $.ajax({



            url:(isEdit ?editShopUrl :register),

            type:'POST',

            data:formatDate,

            cache:false,

            contentType:false,

            processData:false,

            success : function(data){

                if (data.success){

                    $.toast('提交成功');

                    $('#captcha_img').click();

                }else {

                    $.toast('提交失败'+data.errMsg);

                    $('#captcha_img').click();

                }




            }

        });



    });


});




/***
 * 生成新的验证码
 * @param img
 */

function changeVerifyCode(img) {

    img.src="../kapta?"+Math.floor(Math.random()*100);

}


