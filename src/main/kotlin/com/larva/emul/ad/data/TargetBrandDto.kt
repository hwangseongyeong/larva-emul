package com.larva.emul.ad.data

import com.fasterxml.jackson.annotation.JsonInclude

data class TargetBrandDto(
        val adTargetBrands: List<TargetBrand>,
        val code: Int = 0,
        val keyword: String = "타겟브랜드"
)

class Con {
    companion object {
        const val LOGO_URL = "https://img.wemep.co.kr/wmp-ad/10/53/81/1588921105381.jpg"
        const val IMG_URL = "https://img.wemep.co.kr/wmp-ad/05/59/27/1589960055927.jpg"
        const val CARD_URL = "http://vod.wonderscdn.app/banner/left_video_icon_coupon_buy.png"
        const val VIDEO_URL = "https://vod.wonderscdn.app/2020/1/16/cebu0121/Default/HLS/cebu0121.m3u8"
        const val WIDTH = 640
        const val HEIGHT = 480
        const val MODE = 0
        const val DEPTH = 4
    }
}

data class TargetBrand (
        var keyword: String,
        var creative: Creative,
        var addId: String = "1",
        var adText: String = "광고",
        var adPopupText: String = "브랜드사가 구매한 광고상품으로 광고 구매가격, 광고 반응률을 고려하여 노출됩니다.",
        var brandName: String = "브랜드관",
        var mode: Int = Con.MODE,
        var depth: Int = Con.DEPTH,
        var labelType: Int = 1,
        var landing: Landing = Landing()
)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Creative(
        var type: Type,
        var image: Image? = null,
        var video: Video? = null,
        var logos: List<Logo>? = null,
        var logoUrl: String? = null,
        var deals: List<DealInfo>? = null
){
    enum class Type {
        IMAGE,
        DEAL,
        NEW_PRODUCT,
        VIDEO,
        LOGO
    }
}

data class Image (
        var url: String = Con.IMG_URL,
        var width: Int = Con.WIDTH,
        var height: Int = Con.HEIGHT,
        var mode: Int = Con.MODE,
        var depth: Int = Con.DEPTH,
        var landing: Landing = Landing(),
        var link: Link = Link(),
        var tracker: TargetBrandTracker = TargetBrandTracker()
)

data class Video (
        var url: String = Con.VIDEO_URL,
        var thumbnailUrl: String = "http://vod.wonderscdn.app/2020/1/16/cebu0121/Default/Thumbnails/cebu0121.jpg",
        var thumbnailDownsizeUrl: String = "http://vod.wonderscdn.app/2020/1/16/cebu0121/Default/Thumbnails/cebu0121.jpg",
        var cardLeft: Card = Card(Card.Type.AFTER_START),
        var cardRight: Card = Card(Card.Type.BEFORE_END),
        var mode: Int = Con.MODE,
        var depth: Int = Con.DEPTH,
        var landing: Landing = Landing(),
        var link: Link = Link(),
        var tracker: SearchTracker = SearchTracker()
)

data class Logo (
        var addId: String = "1"
)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Landing(
        var type: Int = 5,
        var value: String = "611111111",
        var param: Parameter? = null
){
    data class Parameter(var searchKeyword: String)
}

data class DealInfo (
        var targetBrandCreativeId: Long = 1,
        var dealId: Long = 611111111,
        var keyword: String = "타겟브랜드",
        var dealType: Int = 0
)

data class TargetBrandTracker(var addId: String = "1")

data class SearchTracker(
        var addId: String = "1",
        var adImpressionUrl: String = "http:/test-api-log.wemakeprice.com/ad_search.php?add_id=16427&media=WEMAKEPRICE&ad_product_type=TARGET_BRAND&add_type=view&keyword=&position=",
        var adClickUrl: String = "http:/test-api-log.wemakeprice.com/ad_search.php?add_id=16427&media=WEMAKEPRICE&ad_product_type=TARGET_BRAND&add_type=click&keyword=&position="
)

data class Card (
        var type: Type,
        var url: String = Con.CARD_URL,
        var duration: Int = 1
) {
    enum class Type {
        AFTER_START,
        BEFORE_END
    }
}

data class Link(
        var type: String = "DEAL",
        var value: String = "611111111"
)