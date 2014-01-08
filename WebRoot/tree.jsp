<%@ page contentType="text/html; charset=utf-8"%>  
  
<%@page import="java.util.Iterator"%>  
<%@page import="java.util.List"%>  
<%@page import="com.exam.model.Node"%>
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <title>栏目树</title>  
  
        <script type="text/javascript">  
            <!--  
              
            /**  
             *初始化数据  
             */  
            function loadData() {  
                var nodes = new Array();  
                var index = 0;  
                  
                <%  
                for(Iterator iter = ((List)request.getAttribute("nodes")).iterator(); iter.hasNext();){  
                    Node node = (Node)iter.next();  
                %>  
                  
                nodes[index++] = ["<%=node.getNodeId()%>", "<%=node.getNodeName()%>", "<%=node.getNodeType()%>", "<%=node.getUri()%>", "<%=node.getParentNode().getNodeId()%>"];  
                  
                <%  
                }  
                %>  
                  
                return nodes;  
            }  
              
            /**  
             *初始化栏目树  
             */  
            function initTree(){  
                var nodes = loadData();  
                initNode(nodes, "", 0);  
                reviseIcon();  
                callbackNode();  
            }  
              
            /**  
             *初始化节点  
             *@param nodes 所有节点  
             *@param id 当前节点id  
             *@param num 位移量  
             */  
            function initNode(nodes, id, num){  
                var tree = document.getElementById("tree");  
                  
                for(var index = 0, count = 0; index < nodes.length; index++){  
                    if(nodes[index][4] == id){  
                        count++;  
                        var row = tree.insertRow(tree.rows.length);  
                        var cell = row.insertCell(0);  
                        cell.id = 0 + [index][0];  
                          
                        if(subCount(id, nodes) == count){  
                            cell.innerHTML = initHtml(num, index, nodes, "L");  
                        }else{  
                            cell.innerHTML = initHtml(num, index, nodes, "T");  
                        }  
                          
                        initNode(nodes, nodes[index][0], num + 1);  
                    }  
                }  
            }  
              
            /**  
             *初始化节点内的html代码  
             *@param num 位移量  
             *@param index 本节点在所有节点里的序号  
             *@param nodes 所有节点  
             *@param shape 图标前缀，T or L，自己看看图标就知道有什么不同了。  
             */  
            function initHtml(num, index, nodes, shape){  
                var html = "";  
                  
                for(var count = 0; count < num; count++){  
                    html += "<img src='icon/tree/blank.png' align='absMiddle' />";  
                }  
                  
                html += isEmpty(nodes[index][0], nodes, shape);  
                html += "<img src='icon/tree/" + (nodes[index][2] == "folder" ? "open" : "link") + ".png' align='absmiddle' />";  
                html += initLabel(index, nodes);  
                  
                return html;  
            }  
              
            /**  
             *初始化文字  
             *@param index 本节点在所有节点里的序号  
             *@param nodes 所有节点  
             */  
            function initLabel(index, nodes){  
                var label = "<"  
                  
                if(nodes[index][3] == ""){  
                    label += "span>&nbsp;" + nodes[index][1] + "</span>";  
                }else{  
                    label += "a target='main' href='" + nodes[index][3] + "'>&nbsp;" + nodes[index][1] + "</a>";  
                }  
                  
                return label;  
            }  
              
            /**  
             *判断本节点是否有子结点，并初始化展开图标  
             *@param id 当前节点id  
             *@param nodes 所有节点  
             *@param shape 图标前缀，T or L，自己看看图标就知道有什么不同了。  
             */  
            function isEmpty(id, nodes, shape){  
                var img = "<img src='icon/tree/";  
                var icon = shape;  
              
                for(var index = 0; index < nodes.length; index++){  
                    if(id == nodes[index][4]){  
                        icon += "minus";  
                        break;  
                    }  
                }  
                  
                img += icon + ".png' align='absMiddle'";  
                  
                if(icon.indexOf("minus") > -1){  
                    img += " style='cursor: pointer;' onclick='changeStyle(this);'";  
                }  
                  
                img += " />";  
                  
                return img;  
            }  
              
            /**  
             *计算有多少个子结点  
             *@param id 当前节点id  
             *@param nodes 所有节点  
             */  
            function subCount(id, nodes){  
                var count = 0;  
              
                for(var index = 0; index < nodes.length; index++){  
                    if(nodes[index][4] == id){  
                        count++;  
                    }  
                }  
                  
                return count;  
            }  
              
            /**  
             *修正节点前位移的图标  
             */  
            function reviseIcon(){  
                var rows = document.getElementById("tree").rows;  
              
                for(var index = 1; index < rows.length; index++){  
                    var preChildNodes = rows[index - 1].cells[0].childNodes;  
                    var childNodes = rows[index].cells[0].childNodes;  
                      
                    for(var count = 0; count < childNodes.length - 3; count++){  
                        var preImg = preChildNodes[count];  
                        var img = childNodes[count];  
                      
                        if(preImg.src.indexOf("T") > -1 || preImg.src.indexOf("I") > -1){  
                            img.src = "icon/tree/I.png";  
                        }  
                    }  
                }  
            }  
              
            /**  
             *点击展开图标时所触发的事件  
             *@param icon 当前图标  
             */  
            function changeStyle(icon){  
                changeIcon(icon);  
                changeDisplay(icon.parentNode.parentNode.rowIndex);  
            }  
              
            /**  
             *改变文件夹图标  
             *@param icon 当前图标  
             */  
            function changeIcon(icon){  
                var folder = icon.parentNode.childNodes(icon.parentNode.childNodes.length - 2);  
                  
                if(folder.src.indexOf("folder") > -1){  
                    folder.src = "icon/tree/open.png";  
                }else if(folder.src.indexOf("open") > -1){  
                    folder.src = "icon/tree/folder.png";  
                }  
                  
                if(icon.src.indexOf("Tminus") > -1){  
                    icon.src = "icon/tree/Tplus.png";  
                }else if(icon.src.indexOf("Tplus") > -1){  
                    icon.src = "icon/tree/Tminus.png";  
                }else if(icon.src.indexOf("Lminus") > -1){  
                    icon.src = "icon/tree/Lplus.png";  
                }else if(icon.src.indexOf("Lplus") > -1){  
                    icon.src = "icon/tree/Lminus.png";  
                }  
            }  
              
            /**  
             *改变文件夹图标成指定图标  
             *@param icon 当前图标  
             *@param img 所要变成的图标  
             */  
            function changeImg(icon, img){  
                var folder = icon.parentNode.childNodes(icon.parentNode.childNodes.length - 2);  
                  
                if(folder.src.indexOf("link") < 0){  
                    if(img.indexOf("minus") > -1){  
                        folder.src = "icon/tree/open.png";  
                    }else if(img.indexOf("plus") > -1){  
                        folder.src = "icon/tree/folder.png";  
                    }  
                }  
                  
                if(icon.src.indexOf("Tminus") > -1 || icon.src.indexOf("Tplus") > -1){  
                    icon.src = "icon/tree/T" + img + ".png";  
                }else if(icon.src.indexOf("Lminus") > -1 || icon.src.indexOf("Lplus") > -1){  
                    icon.src = "icon/tree/L" + img + ".png";  
                }  
            }  
              
            /**  
             *当前行在表格内的序号  
             *@param rowIndex 行号  
             */  
            function changeDisplay(rowIndex){  
                var tree = document.getElementById("tree");  
                var baseCount = subStrNum(tree.rows[rowIndex].cells[0].innerHTML, "IMG");  
              
                for(var index = rowIndex + 1; index < tree.rows.length;index++){  
                    var row = tree.rows[index];  
                    var count = subStrNum(row.cells[0].innerHTML, "IMG");  
                      
                    if(count > baseCount){  
                        if(row.style.display == ""){  
                            row.style.display = "none";  
                            changeImg(row.cells[0].childNodes[row.cells[0].childNodes.length - 3], "minus");  
                        }else if(count == baseCount + 1){  
                            row.style.display = "";  
                            changeImg(row.cells[0].childNodes[row.cells[0].childNodes.length - 3], "plus");  
                        }  
                    }else{  
                        break;  
                    }  
                }  
            }  
              
            /**  
             *计算一字符串在另一字符串内出现的次数  
             *@param arg 字符串  
             *@param subArg 另一字符串  
             */  
            function subStrNum(arg, subArg){  
                var count = 0  
              
                for(; arg.indexOf(subArg) > -1; argarg = arg.substr(arg.indexOf(subArg) + subArg.length)){  
                    count++;  
                }  
                  
                return count;  
            }  
              
            /**  
             *当栏目树初始化完成时，收回所有展开的节点  
             */  
            function callbackNode(){  
                var rows = document.getElementById("tree").rows;  
                  
                for(var index = rows.length - 1; index >= 0; index--){  
                    rows[index].cells[0].childNodes[rows[index].cells[0].childNodes.length - 3].click();  
                }  
            }  
            //-->  
        </script>  
    </head>  
  
    <body onload="initTree();"  
        style="width: 100%; height: 100%; float: left; border: 1px solid #99BEEF; background: #D2E4FC;">  
        <table id="tree" cellpadding="0" cellspacing="0">  
        </table>  
    </body>  
</html>  