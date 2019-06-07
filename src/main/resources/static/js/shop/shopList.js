 $(function () {

     getList();

     function getList() {

         $.ajax({

             url:'/shopAdmin/getShopList',

             type:'get',

             dataType:'json',

             success:function(data){

                 if (data.success){

                     handleUser(data.user);

                      handleList(data.shopList);
                 }

             },

         });
         
     }

     function handleUser(data) {


          // $('#user-name').val(data.name);

         document.getElementById("user-name").innerText=data.name;



     }

 }) ;




function handleList(data) {


    var shopListHtml = '';

    data.map(function (item,index){

        shopListHtml += '<div class="row row-shop"> <div class="col-40">'

        +item.shopName+'</div> <div class="col-40">' + shopStatus(item.shopStatus)

        +'</div> <div class="col-20">'+goShop(item.enableStatus,item.shopId)+'</div></div>';


    });


    $('#shopLists').html(shopListHtml);



}

function shopStatus(data){

    if (data==0){

        return "审核中";

    }else if (data ==-1 ) {

        return "店铺非法";

    }else {

        return "审核通过";

    }
}


function goShop(status,id){


    if (status == 1){

        return '<a href="/shopAdmin/shopManage?shopId='+id+'">'+"进入"+'</a>';
    }else {

        return '';
    }

}