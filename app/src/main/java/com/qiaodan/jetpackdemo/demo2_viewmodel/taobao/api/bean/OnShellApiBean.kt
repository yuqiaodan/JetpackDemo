package com.qiaodan.jetpackdemo.demo2_viewmodel.taobao.api.bean


/**
 * author: created by yuqiaodan on 2022/12/28 17:54
 * description:
 */

data class OnShellApiBean(
    val tbk_dg_optimus_material_response: TbkDgOptimusMaterialResponse
) {
    data class TbkDgOptimusMaterialResponse(
        val is_default: String,
        val request_id: String,
        val result_list: ResultList
    ) {
        data class ResultList(
            val map_data: MutableList<OnShellItem>
        )
    }

}





