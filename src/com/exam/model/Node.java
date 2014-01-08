package com.exam.model;

import java.util.HashSet;  
import java.util.Set;  
  
/** 
 * 栏目树节点 
 * @author Dave 
 */  
public class Node {  
  
    /** 
     * 唯一标示符 
     */  
    private int nodeId;  
    /** 
     * 节点名称 
     */  
    private String nodeName;  
    /** 
     * 节点类型，现在只有2个选择：1.folder/文件夹，2.link/链接 
     */  
    private String nodeType;  
    /** 
     * 链接 
     */  
    private String uri;   
      
    /** 
     * 父节点 
     */  
    private Node parentNode;  
    /** 
     * 子结点 
     */  
    private Set subNodes = new HashSet(0);  
  
    public Node() {  
  
    }  
  
    public Node(int nodeId) {  
        this.nodeId = nodeId;  
    }  
  
    public Node(int nodeId, String nodeName, String nodeType, String uri,  
            Node parentNode, Set subNodes) {  
        this.nodeId = nodeId;  
        this.nodeName = nodeName;  
        this.nodeType = nodeType;  
        this.uri = uri;  
        this.parentNode = parentNode;  
        this.subNodes = subNodes;  
    }  
  
    public Node getParentNode() {  
        return parentNode;  
    }  
  
    public void setParentNode(Node parentNode) {  
        this.parentNode = parentNode;  
    }  
  
    public int getNodeId() {  
        return nodeId;  
    }  
  
    public void setNodeId(int nodeId) {  
        this.nodeId = nodeId;  
    }  
  
    public String getNodeName() {  
        return nodeName;  
    }  
  
    public void setNodeName(String nodeName) {  
        this.nodeName = nodeName;  
    }  
  
    public String getNodeType() {  
        return nodeType;  
    }  
  
    public void setNodeType(String nodeType) {  
        this.nodeType = nodeType;  
    }  
  
    public String getUri() {  
        return uri;  
    }  
  
    public void setUri(String uri) {  
        this.uri = uri;  
    }  
  
    public Set getSubNodes() {  
        return subNodes;  
    }  
  
    public void setSubNodes(Set subNodes) {  
        this.subNodes = subNodes;  
    }  
  
}  