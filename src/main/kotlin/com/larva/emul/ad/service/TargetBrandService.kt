package com.larva.emul.ad.service

import com.larva.emul.ad.data.*
import org.springframework.stereotype.Service

@Service
class TargetBrandService {

    fun getTargetBrand(keyword: String) = when(keyword) {
            "이미지" ->  getImage(keyword)
            "비디오" ->  getVideo(keyword)
            "로고" ->  getLogo(keyword)
            "딜" -> getDeal(keyword)
            "뉴딜" -> getNewProduct(keyword)
            else -> getImage(keyword)
    }

    fun getVideo(keyword:String): TargetBrandDto {
        var creative = Creative(Creative.Type.VIDEO)
        creative.video = Video()
        return TargetBrandDto(keyword, listOf(TargetBrand(keyword, creative)))
    }

    fun getImage(keyword:String): TargetBrandDto {
        var creative = Creative(Creative.Type.IMAGE)
        creative.image = Image()
        return TargetBrandDto(keyword, listOf(TargetBrand(keyword, creative)))
    }

    fun getLogo(keyword:String): TargetBrandDto {
        var creative = Creative(Creative.Type.LOGO)
        creative.logos = listOf(Logo(), Logo(), Logo(), Logo())
        return TargetBrandDto(keyword, listOf(TargetBrand(keyword, creative)))
    }

    fun getDeal(keyword:String): TargetBrandDto {
        var creative = Creative(Creative.Type.DEAL)
        creative.deals = listOf(DealInfo(),DealInfo(),DealInfo(),DealInfo(),DealInfo())
        return TargetBrandDto(keyword, listOf(TargetBrand(keyword, creative)))
    }

    fun getNewProduct(keyword:String): TargetBrandDto {
        var creative = Creative(Creative.Type.NEW_PRODUCT)
        creative.deals = listOf(DealInfo())
        return TargetBrandDto(keyword, listOf(TargetBrand(keyword, creative)))
    }
}