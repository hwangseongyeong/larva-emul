package com.larva.emul.ad.service

import com.larva.emul.ad.data.*
import org.springframework.stereotype.Service

@Service
class TargetBrandService {

    fun getVideo(keyword:String): TargetBrandDto {
        var creative = Creative(Creative.Type.VIDEO)
        creative.video = Video()
        return TargetBrandDto(listOf(TargetBrand(keyword, creative)))
    }

    fun getImage(keyword:String): TargetBrandDto {
        var creative = Creative(Creative.Type.IMAGE)
        creative.image = Image()
        return TargetBrandDto(listOf(TargetBrand(keyword, creative)))
    }

    fun getLogo(keyword:String): TargetBrandDto {
        var creative = Creative(Creative.Type.LOGO)
        creative.logos = listOf(Logo(), Logo(), Logo(), Logo())
        return TargetBrandDto(listOf(TargetBrand(keyword, creative)))
    }

    fun getDeal(keyword:String): TargetBrandDto {
        var creative = Creative(Creative.Type.DEAL)
        creative.deals = listOf(DealInfo(),DealInfo(),DealInfo(),DealInfo(),DealInfo())
        return TargetBrandDto(listOf(TargetBrand(keyword, creative)))
    }

    fun getNewProduct(keyword:String): TargetBrandDto {
        var creative = Creative(Creative.Type.NEW_PRODUCT)
        creative.deals = listOf(DealInfo())
        return TargetBrandDto(listOf(TargetBrand(keyword, creative)))
    }
}