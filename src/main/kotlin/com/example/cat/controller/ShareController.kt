package com.example.cat.controller

import com.example.cat.controller.dto.SaveShareRecordRequest
import com.example.cat.controller.dto.ShareRecordDto
import com.example.cat.service.ShareService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "share", description = "나눔 내역 관련 api")
@RestController
@RequestMapping("/api/share")
class ShareController(
    private val shareService: ShareService,
) {
    @Operation(summary = "나눔 내역 저장 api", description = "댓글에 나눔 성사 버튼 클릭시 나눔 성사 내역을 저장하는 api 입니다. 나눔 받는/ 나눔 하는 유저 각각 일어나야 하는 이벤트입니다.")
    @PostMapping
    fun save(@RequestBody request: SaveShareRecordRequest) {
        return shareService.shareSuccess(
            ShareService.Request(
                shareUserId = request.shareUserId,
                receiveUserId = request.receiveUserId,
                postId = request.postId,
            )
        )
    }
}