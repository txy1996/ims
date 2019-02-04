package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxProductRequest;

public interface WxProductRequestDao {

	//, @Param("timechoise")String timechoise, @Param("naturechoise")String naturechoise
	List<WxProductRequest> shoplist(@Param("id")Integer id, @Param("ptitle1")String ptitle1,@Param("ptitle2")String ptitle2,@Param("ptitle3")String ptitle3);

	List<WxProductRequest> restaurant(Integer id);

	List<WxProductRequest> listsang(Integer id1);

	List<WxProductRequest> listtravel(Integer id2);

	WxProductRequest adviser(Integer id);

	List<WxProductRequest> adviserId(@Param("id")Integer id,@Param("id1")Integer id1);

	List<WxProductRequest> Besimilar(@Param("id")Integer id);

	List<WxProductRequest> morelecturer(@Param("id")Integer id, @Param("ptitle1")String ptitle1,@Param("ptitle2")String ptitle2);

	List<WxProductRequest> morecourse(@Param("id")Integer id, @Param("ptitle1")String ptitle1,@Param("ptitle2")String ptitle2,@Param("ptitle3")String ptitle3);

	List<WxProductRequest> specificourse(Integer id);

	List<WxProductRequest> details(Integer id);

	List<WxProductRequest> Moresites(@Param("id")Integer id, @Param("ptitle1")String ptitle1,@Param("ptitle2")String ptitle2);

	List<WxProductRequest> Traveldetails(Integer id);

	List<WxProductRequest> shoplisth(String classs);

	List<WxProductRequest> forward(Integer id);

	List<WxProductRequest> teacher(Integer id);

	List<WxProductRequest> Matching(@Param("id")Integer id, @Param("ptitle1")String ptitle1,@Param("ptitle2")String ptitle2);

	List<WxProductRequest> Travel(@Param("id")Integer id, @Param("ptitle1")String ptitle1,@Param("ptitle2")String ptitle2);

	List<WxProductRequest> productclass(Integer id);

	List<WxProductRequest> XqMatching(Integer id);

	List<WxProductRequest> lbshop(String string);

	WxProductRequest productfid(Integer id);

	List<WxProductRequest> wshop(String string);

	List<WxProductRequest> schema(@Param("id")Integer id, @Param("ptitle1")String ptitle1, @Param("ptitle2")String ptitle2);

}
