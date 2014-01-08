package com.exam.util;

public interface Pageable extends java.sql.ResultSet{ 
/**������ҳ�� 
*/ 
int getPageCount(); 
/**���ص�ǰҳ�ļ�¼���� 
*/ 
int getPageRowsCount(); 
/**���ط�ҳ��С 
*/ 
int getPageSize(); 
/**ת��ָ��ҳ 
*/ 
void gotoPage(int page) ; 
/**���÷�ҳ��С 
*/ 
void setPageSize(int pageSize); 
/**�����ܼ�¼���� 
*/ 
int getRowsCount(); 
/** 
* ת����ǰҳ�ĵ�һ����¼ 
* @exception java.sql.SQLException �쳣˵���� 
*/ 
void pageFirst() throws java.sql.SQLException; 
/** 
* ת����ǰҳ�����һ����¼ 
* @exception java.sql.SQLException �쳣˵���� 
*/ 
void pageLast() throws java.sql.SQLException; 
/**���ص�ǰҳ�� 
*/ 
int getCurPage(); 
} 