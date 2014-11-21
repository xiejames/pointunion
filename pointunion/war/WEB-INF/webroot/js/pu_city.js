// JavaScript Document
var city1 = ["\u4e1c\u57ce","\u897f\u57ce","\u5d07\u6587","\u5ba3\u6b66","\u671d\u9633","\u6d77\u6dc0","\u4e30\u53f0","\u77f3\u666f\u5c71","\u95e8\u5934\u6c9f","\u623f\u5c71","\u901a\u5dde","\u987a\u4e49","\u660c\u5e73","\u5927\u5174","\u5e73\u8c37","\u6000\u67d4","\u5bc6\u4e91","\u5176\u5b83"];
var city2 = ["\u9ec4\u6d66","\u5362\u6e7e","\u5f90\u6c47","\u957f\u5b81","\u9759\u5b89","\u666e\u9640","\u95f8\u5317","\u8679\u53e3","\u6768\u6d66","\u5b9d\u5c71","\u95f5\u884c","\u5609\u5b9a","\u6d66\u4e1c","\u677e\u6c5f","\u91d1\u5c71","\u9752\u6d66","\u5357\u6c47","\u5949\u8d24","\u5d07\u660e","\u5176\u5b83"];
var city3 = ["\u548c\u5e73","\u6cb3\u4e1c","\u6cb3\u897f","\u5357\u5f00","\u6cb3\u5317","\u7ea2\u6865","\u5858\u6cbd","\u6c49\u6cbd","\u5927\u6e2f","\u4e1c\u4e3d","\u897f\u9752","\u5317\u8fb0","\u6d25\u5357","\u6b66\u6e05","\u5b9d\u577b","\u9759\u6d77","\u5b81\u6cb3","\u84df\u53bf","\u5176\u5b83"];
var city4 = ["\u6e1d\u4e2d","\u5927\u6e21\u53e3","\u6c5f\u5317","\u6c99\u576a\u575d","\u4e5d\u9f99\u5761","\u5357\u5cb8","\u5317\u789a","\u4e07\u76db","\u53cc\u6865","\u6e1d\u5317","\u5df4\u5357","\u4e07\u5dde","\u6daa\u9675","\u9ed4\u6c5f","\u6c38\u5ddd","\u5408\u5ddd","\u6c5f\u6d25","\u5357\u5ddd","\u957f\u5bff","\u7da6\u6c5f","\u6f7c\u5357","\u8363\u660c","\u74a7\u5c71","\u5927\u8db3","\u94dc\u6881","\u6881\u5e73","\u57ce\u53e3","\u57ab\u6c5f","\u6b66\u9686","\u4e30\u90fd","\u5949\u8282","\u5f00\u53bf","\u4e91\u9633","\u5fe0\u53bf","\u5deb\u6eaa","\u5deb\u5c71","\u77f3\u67f1","\u79c0\u5c71","\u9149\u9633","\u5f6d\u6c34"];
var city5 = ["\u54c8\u5c14\u6ee8","\u9f50\u9f50\u54c8\u5c14","\u9e64\u5c97","\u53cc\u9e2d\u5c71","\u9e21\u897f","\u4f73\u6728\u65af","\u4e03\u53f0\u6cb3","\u9ed1\u6cb3","\u7261\u4e39\u6c5f","\u5927\u5e86","\u7ee5\u82ac\u6cb3","\u5c1a\u5fd7","\u4f0a\u6625","\u5176\u5b83"];
var city6 = ["\u957f\u6625","\u5409\u6797","\u629a\u677e","\u9f99\u4e95","\u6885\u6cb3\u53e3","\u56db\u5e73","\u8fbd\u6e90","\u901a\u5316","\u5ef6\u5409","\u96c6\u5b89","\u5927\u5b89","\u6d51\u6c5f","\u767d\u5c71","\u677e\u539f","\u767d\u57ce","\u5ef6\u8fb9","\u5176\u5b83"];
var city7 = ["\u6c88\u9633","\u5927\u8fde","\u978d\u5c71","\u672c\u6eaa","\u4e39\u4e1c","\u629a\u987a","\u9526\u5dde","\u846b\u82a6\u5c9b","\u8fbd\u9633","\u8425\u53e3","\u76d8\u9526","\u961c\u65b0","\u671d\u9633","\u94c1\u5cad","\u4e1c\u6e2f","\u5176\u5b83"];
var city8 = ["\u547c\u548c\u6d69\u7279","\u5305\u5934","\u4e4c\u6d77","\u8d64\u5cf0","\u901a\u8fbd","\u9102\u5c14\u591a\u65af","\u4e4c\u5170\u5bdf\u5e03","\u547c\u4f26\u8d1d\u5c14","\u6ee1\u6d32\u91cc","\u6d77\u62c9\u5c14","\u4e4c\u5170\u6d69\u7279","\u9521\u6797\u6d69\u7279","\u4e1c\u80dc","\u5176\u5b83"];
var city9 = ["\u4e4c\u9c81\u6728\u9f50","\u54c8\u5bc6","\u4f0a\u7281","\u5580\u4ec0","\u77f3\u6cb3\u5b50","\u5e93\u5c14\u52d2","\u548c\u7530","\u514b\u62c9\u739b\u4f9d","\u594e\u5c6f","\u660c\u5409","\u535a\u4e50","\u5410\u9c81\u756a","\u963f\u52d2\u6cf0","\u5176\u5b83"];
var city10 = ["\u5170\u5dde","\u6566\u714c","\u5929\u6c34","\u91d1\u660c","\u767d\u94f6","\u6b66\u5a01","\u5609\u5cea\u5173","\u9152\u6cc9","\u5b9a\u897f\u5730\u533a","\u5e73\u51c9\u5730\u533a","\u5e86\u9633\u5730\u533a","\u9647\u5357\u5730\u533a","\u5f20\u6396\u5730\u533a","\u7518\u5357\u5dde","\u4e34\u590f\u5dde","\u5176\u5b83"];
var city11 = ["\u897f\u5b81","\u6d77\u5357\u5dde","\u9ec4\u5357\u81ea\u6cbb\u5dde","\u6e5f\u4e2d\u53bf","\u683c\u5c14\u6728","\u8d35\u5fb7\u53bf","\u5c16\u624e\u53bf","\u4e4c\u5170\u53bf","\u5176\u5b83"];
var city12 = ["\u897f\u5b89","\u94dc\u5ddd","\u5ef6\u5b89","\u5b9d\u9e21","\u97e9\u57ce","\u6c49\u4e2d","\u54b8\u9633","\u6e2d\u5357","\u534e\u9634","\u6986\u6797","\u5b89\u5eb7","\u5176\u5b83"];
var city13 = ["\u592a\u539f","\u5927\u540c","\u4faf\u9a6c","\u9633\u6cc9","\u4e94\u53f0\u5c71","\u8fd0\u57ce","\u957f\u6cbb","\u664b\u57ce","\u664b\u4e2d","\u6714\u5dde","\u5ffb\u5dde","\u4e34\u6c7e","\u5176\u5b83"];
var city14 = ["\u6d4e\u5357","\u9752\u5c9b","\u70df\u53f0","\u6cf0\u5b89","\u5a01\u6d77","\u84ec\u83b1","\u66f2\u961c","\u6f4d\u574a","\u6dc4\u535a","\u5fb7\u5dde","\u4e34\u6c82","\u65e5\u7167","\u8363\u57ce","\u6587\u767b","\u67a3\u5e84","\u804a\u57ce","\u8377\u6cfd","\u83b1\u9633","\u83b1\u5dde","\u9f99\u53e3","\u6d4e\u5b81","\u4e1c\u8425","\u6ee8\u5dde","\u5176\u5b83"];
var city15 = ["\u6210\u90fd","\u6500\u679d\u82b1","\u7ef5\u9633","\u4e50\u5c71","\u4e5d\u5be8\u6c9f","\u6c5f\u6cb9","\u5357\u5145","\u5b9c\u5bbe","\u81ea\u8d21","\u6cf8\u5dde","\u5185\u6c5f","\u5fb7\u9633","\u96c5\u5b89","\u5e7f\u5143","\u9042\u5b81","\u5e7f\u5b89","\u8fbe\u5dde","\u5df4\u4e2d","\u7709\u5c71","\u8d44\u9633","\u5176\u5b83"];
var city16 = ["\u8d35\u9633","\u5b89\u987a","\u9075\u4e49","\u516d\u76d8\u6c34","\u94dc\u4ec1\u5730\u533a","\u6bd5\u8282\u5730\u533a","\u9ed4\u897f\u5357","\u9ed4\u4e1c\u5357","\u9ed4\u5357","\u5176\u5b83"];
var city17 = ["\u6606\u660e","\u66f2\u9756","\u5927\u7406","\u4e3d\u6c5f","\u897f\u53cc\u7248\u7eb3","\u695a\u96c4","\u7ea2\u6cb3\u5dde","\u666f\u6d2a","\u745e\u4e3d","\u7389\u6eaa","\u4fdd\u5c71","\u662d\u901a","\u4e2a\u65e7","\u6012\u6c5f","\u5176\u5b83"];
var city18 = ["\u5357\u5b81","\u6842\u6797","\u5317\u6d77","\u67f3\u5dde","\u68a7\u5dde","\u8861\u9633","\u7389\u6797","\u9632\u57ce\u6e2f","\u94a6\u5dde","\u5176\u5b83"];
var city19 = ["\u5e7f\u5dde","\u6df1\u5733","\u73e0\u6d77","\u4f5b\u5c71","\u6c55\u5934","\u4e2d\u5c71","\u6e5b\u6c5f","\u6c5f\u95e8","\u8087\u5e86","\u4e1c\u839e","\u987a\u5fb7","\u5357\u6d77","\u4e09\u6c34","\u65b0\u4f1a","\u60e0\u5dde","\u6f6e\u9633","\u6f6e\u5dde","\u4ece\u5316","\u756a\u79ba","\u8302\u540d","\u6885\u5dde","\u6cb3\u6e90","\u5f00\u5e73","\u666e\u5b81","\u6e05\u8fdc","\u97f6\u5173","\u53f0\u5c71","\u9633\u6c5f","\u5316\u5dde","\u96f7\u5dde","\u56db\u4f1a","\u4e91\u6d6e","\u5176\u5b83"];
var city20 = ["\u957f\u6c99","\u5cb3\u9633","\u8861\u9633","\u682a\u6d32","\u90f4\u5dde","\u6000\u5316","\u5e38\u5fb7","\u5927\u5eb8","\u5f20\u5bb6\u754c","\u90b5\u9633","\u6e58\u6f6d","\u97f6\u5c71","\u6c38\u5dde","\u5a04\u5e95","\u5176\u5b83"];
var city21 = ["\u6b66\u6c49","\u9ec4\u77f3","\u5341\u5830","\u8944\u6a0a","\u5b9c\u660c","\u8346\u5dde","\u9102\u5dde","\u6c99\u5e02","\u795e\u519c\u67b6","\u968f\u5dde","\u5b5d\u611f","\u9ec4\u5188","\u5927\u51b6","\u54b8\u5b81","\u6069\u65bd","\u8346\u95e8","\u6d2a\u6e56","\u4ed9\u6843","\u5176\u5b83"];
var city22 = ["\u5357\u660c","\u4e5d\u6c5f","\u666f\u5fb7\u9547","\u9e70\u6f6d","\u8d63\u5dde","\u4e30\u57ce","\u629a\u5dde","\u5e90\u5c71","\u840d\u4e61","\u4e0a\u9976","\u65b0\u4f59","\u5409\u5b89","\u5b9c\u6625","\u5176\u5b83"];
var city23 = ["\u676d\u5dde","\u5b81\u6ce2","\u6e29\u5dde","\u5609\u5174","\u7ecd\u5174","\u91d1\u534e","\u53f0\u5dde","\u4e3d\u6c34","\u821f\u5c71","\u8862\u5dde","\u6e56\u5dde","\u4e49\u4e4c","\u5176\u5b83"];
var city24 = ["\u5357\u4eac","\u82cf\u5dde","\u5357\u901a","\u626c\u5dde","\u5f90\u5dde","\u8fde\u4e91\u6e2f","\u5e38\u5dde","\u65e0\u9521","\u5e38\u719f","\u5f20\u5bb6\u6e2f","\u5b9c\u5174","\u76d0\u57ce","\u6c5f\u9634","\u4e39\u9633","\u9ad8\u90ae","\u6dee\u9634","\u6c5f\u90fd","\u6606\u5c71","\u6cf0\u5dde","\u5434\u6c5f","\u9521\u5c71","\u9547\u6c5f","\u626c\u4e2d","\u542f\u4e1c","\u592a\u4ed3","\u9756\u6c5f","\u5bbf\u8fc1","\u5176\u5b83"];
var city25 = ["\u5408\u80a5","\u9ec4\u5c71","\u829c\u6e56","\u94dc\u9675","\u5b89\u5e86","\u868c\u57e0","\u9a6c\u978d\u5c71","\u6dee\u5317","\u5ba3\u57ce\u5730\u533a","\u9752\u9633","\u6dee\u5357","\u6ec1\u5dde","\u5ba3\u5dde\u5730\u533a","\u5b81\u56fd","\u4e1c\u6e2f","\u961c\u9633","\u5bbf\u5dde","\u5de2\u6e56","\u516d\u5b89","\u6c60\u5dde","\u5176\u5b83"];
var city26 = ["\u798f\u5dde","\u53a6\u95e8","\u4e09\u660e","\u6cc9\u5dde","\u6f33\u5dde","\u664b\u6c5f","\u8386\u7530","\u6b66\u5937\u5c71","\u77f3\u72ee","\u5357\u5e73","\u5b81\u5fb7","\u798f\u6e05","\u798f\u5b89","\u9f99\u5ca9","\u5357\u5b89","\u5176\u5b83"];
var city27 = ["\u6d77\u53e3","\u4e09\u4e9a","\u901a\u4ec0","\u6587\u660c","\u660c\u6c5f","\u743c\u6d77","\u4e07\u5b81","\u4e94\u6307\u5c71","\u510b\u5dde","\u5176\u5b83"];
var city28 = ["\u90d1\u5dde","\u5f00\u5c01","\u6d1b\u9633","\u4e09\u95e8\u5ce1","\u5e73\u9876\u5c71","\u65b0\u4e61","\u5357\u9633","\u5b89\u9633","\u767b\u5c01","\u7126\u4f5c","\u6c5d\u5dde","\u5546\u4e18","\u8bb8\u660c","\u5468\u53e3","\u76ca\u5dde","\u79b9\u5dde","\u9879\u57ce","\u9e64\u58c1","\u6fee\u9633","\u6f2f\u6cb3","\u9a7b\u9a6c\u5e97","\u5043\u5e08","\u5176\u5b83"];
var city29 = ["\u77f3\u5bb6\u5e84","\u5f20\u5bb6\u53e3","\u79e6\u7687\u5c9b","\u4fdd\u5b9a","\u6ca7\u5dde","\u627f\u5fb7","\u8861\u6c34","\u4efb\u4e18","\u4efb\u90b1","\u5eca\u574a","\u5510\u5c71","\u90af\u90f8","\u8861\u6c34","\u6e05\u6cb3\u53bf","\u90a2\u53f0","\u5176\u5b83"];
var city30 = ["\u94f6\u5ddd","\u4e2d\u536b","\u77f3\u5634\u5c71","\u5434\u5fe0","\u56fa\u539f","\u5176\u5b83"];
var city31 = ["\u62c9\u8428","\u65e5\u5580\u5219\u5730\u533a","\u90a3\u66f2\u5730\u533a","\u5c71\u5357\u5730\u533a","\u660c\u90fd\u5730\u533a","\u5c71\u5357\u5730\u533a","\u963f\u91cc\u5730\u533a","\u5176\u5b83"];
var city32 = ["\u6fb3\u95e8","\u5176\u5b83"];
var city33 = ["\u4e2d\u897f","\u4e1c\u533a","\u4e5d\u9f99\u57ce","\u89c2\u5858","\u5357\u533a","\u6df1\u6c34","\u6e7e\u4ed4","\u9ec4\u5927\u4ed9","\u6cb9\u5c16\u65fa","\u79bb\u5c9b","\u8475\u9752","\u5317\u533a","\u897f\u8d21","\u6c99\u7530","\u5c6f\u95e8","\u5927\u57d4","\u8343\u6e7e","\u5143\u6717","\u5176\u5b83"];
var city34 = ["\u53f0\u5317","\u9ad8\u96c4","\u57fa\u9686","\u53f0\u4e2d","\u53f0\u5357","\u65b0\u7af9","\u5609\u4e49","\u53f0\u5317","\u5b9c\u5170","\u65b0\u7af9","\u6843\u56ed","\u82d7\u6817","\u53f0\u4e2d\u53bf","\u5f70\u5316\u53bf","\u5357\u6295\u53bf","\u5609\u4e49\u53bf","\u4e91\u6797\u53bf","\u53f0\u5357\u53bf","\u9ad8\u96c4\u53bf","\u5c4f\u4e1c\u53bf","\u53f0\u4e1c\u53bf","\u82b1\u83b2\u53bf","\u6f8e\u6e56\u53bf","\u5176\u5b83"];
var city35 = ["\u5176\u5b83"];

var provinceName = ["\u5317\u4eac","\u4e0a\u6d77","\u5929\u6d25","\u91cd\u5e86","\u9ed1\u9f99\u6c5f","\u5409\u6797","\u8fbd\u5b81","\u5185\u8499\u53e4","\u65b0\u7586",
"\u7518\u8083","\u9752\u6d77","\u9655\u897f","\u5c71\u897f","\u5c71\u4e1c","\u56db\u5ddd","\u8d35\u5dde","\u4e91\u5357","\u5e7f\u897f","\u5e7f\u4e1c","\u6e56\u5357","\u6e56\u5317","\u6c5f\u897f",
"\u6d59\u6c5f","\u6c5f\u82cf","\u5b89\u5fbd","\u798f\u5efa","\u6d77\u5357","\u6cb3\u5357","\u6cb3\u5317","\u5b81\u590f","\u897f\u85cf","\u6fb3\u95e8","\u9999\u6e2f","\u53f0\u6e7e","\u5176\u5b83"];



function province(n,m)
{
    var e = document.getElementById("province");
    
    for (var i=0; i<provinceName.length; i++){
   
       var o = new Option(provinceName[i],  provinceName[i]);
       if((n !="") && (n == provinceName[i])){
       		o.selected = true;
       		cityName(i+1,m);
       }
       e.options.add(o);
    }
}

function cityName(n,m)
{
    var e = document.getElementById("city");
    for (var i=e.options.length; i>0; i--)  e.remove(i-1);
    if (n == "") return;
    var a = eval("city"+ n);
    if(m == ""){
    	var o = new Option("\u8bf7\u9009\u62e9\u57ce\u5e02","");
    	e.options.add(o);
    } 
    for (var i=0; i<a.length; i++){
    	var o = new Option(a[i], a[i]);
    	if((m !="") && (m == a[i])){
       		o.selected = true;
       	}
    	e.options.add(o);
    }
}

