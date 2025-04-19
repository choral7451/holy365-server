package goj.holy365.api.bible.interfaces.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goj.holy365.api.bible.domain.service.BibleService;
import goj.holy365.api.bible.interfaces.controller.dto.in.ScanBibleVersesRequest;
import goj.holy365.api.bible.interfaces.controller.dto.out.BibleVerseResponse;
import goj.holy365.common.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bible")
@Tag(name = "Bible", description = "Bible API")
public class BibleController {
	private final BibleService bibleService;

	@GetMapping("/verses")
	@Operation(summary = "fetch bible verses", description = "성경 구절을 조회합니다")
	public ApiResponse<List<BibleVerseResponse>> scanVerses(@Validated @ModelAttribute ScanBibleVersesRequest request) {
		return ApiResponse.success(bibleService.scanVerses(request.toServiceDto()
		).stream().map(BibleVerseResponse::fromInfo).toList());
	}
}
