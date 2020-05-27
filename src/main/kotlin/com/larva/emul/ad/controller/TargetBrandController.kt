package com.larva.emul.ad.controller

import com.larva.emul.ad.service.TargetBrandService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/target-brand")
class TargetBrandController (
        private val targetBrandService: TargetBrandService
) {

    @GetMapping
    fun targetBrand(keyword: String) = targetBrandService.getTargetBrand(keyword)

    @GetMapping("/video")
    fun video(keyword: String) = targetBrandService.getVideo(keyword)

    @GetMapping("/image")
    fun image(keyword: String) = targetBrandService.getImage(keyword)

    @GetMapping("/logo")
    fun logo(keyword: String) = targetBrandService.getLogo(keyword)

    @GetMapping("/deal")
    fun deal(keyword: String) = targetBrandService.getDeal(keyword)

    @GetMapping("/new-product")
    fun newProduct(keyword: String) = targetBrandService.getNewProduct(keyword)
}