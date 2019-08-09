package com.shujuniu.common.rest;

import com.shujuniu.common.AdminMRPContext;
import com.shujuniu.common.Constant;
import com.shujuniu.common.controller.StatusCode;
import com.shujuniu.common.exception.MRPException;
import com.shujuniu.common.utils.NCarsBeanUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;


@Slf4j
public abstract class BaseAdminRestService {

    public static final String MSG_SUCCESS = "操作成功";

    public static final String MSG_FAIL = "操作失败";

    //（0停用 1启用）
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 1;

    /**
     * 获取当前登录用户的用户ID
     * @return
     */
    public Integer getLoginUserId() {
        Integer userId = AdminMRPContext.getContext().getUserId();
        if(userId == null || userId.intValue() <= 0){
            throw new MRPException(StatusCode.NO_LOGIN, "获取不到登录用户");
        }
        return userId;
    }

    public void setOperateDataId(Integer dataId) {
        AdminMRPContext.getContext().setDataId(dataId);
    }

    protected <T> PageListResponse<T> getPageListResponse(BasePageListRequest pageListRequest, AdminUserProfile userProfile, IPageListCallBack callBack) {

        if (pageListRequest == null) {
            throw new MRPException(StatusCode.PARAMETER_LOSE, "获取查询对象失败");
        }


        Integer curPageSize = pageListRequest.getPageSize();
        Integer curPageNo = pageListRequest.getPageNo();
        curPageSize = curPageSize == null || curPageSize.intValue() <= 0 ? Constant.DEFAULT_PER_PAGE_NUM : curPageSize;
        curPageNo = curPageNo == null || curPageNo.intValue() <= 0 ? 1 : curPageNo;

        int startIndex = curPageSize * (curPageNo - 1);
        pageListRequest.setPageNo(curPageNo);
        pageListRequest.setPageSize(curPageSize);
        pageListRequest.setStartIndex(startIndex);
        if (userProfile != null) {
            pageListRequest.setAuthRoleId(userProfile.getRoleId());
            pageListRequest.setAuthCompanyId(userProfile.getCompanyId());
            pageListRequest.setAuthStoreId(userProfile.getStoreId());
            pageListRequest.setAuthUserId(userProfile.getId());
            pageListRequest.setAuthAreaId(userProfile.getAreaId());
        }

        Map<String, Object> pageListParamMap = NCarsBeanUtil.beanToMapOnlyDeclaredFields(pageListRequest);

        List<T> dataList = callBack.getPageDataList(pageListParamMap);

        Integer totalNum = callBack.getPageTotalNum(pageListParamMap);

        totalNum = totalNum == null ? 0 : totalNum;
        int totalPageNum = totalNum % curPageSize == 0 ? totalNum / curPageSize : totalNum / curPageSize + 1;

        PageListResponse pageListResponse = new PageListResponse();
        pageListResponse.setDataList(dataList);
        pageListResponse.setTotalNum(totalNum);
        pageListResponse.setTotalPage(totalPageNum);

        return pageListResponse;
    }
}
