package goj.holy365.api.interfaces.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goj.holy365.api.application.facade.BibleFacade;
import goj.holy365.api.interfaces.controller.dto.in.ScanBibleBooksRequest;
import goj.holy365.api.interfaces.controller.dto.in.ScanBibleChaptersRequest;
import goj.holy365.api.interfaces.controller.dto.in.ScanBibleVersesRequest;
import goj.holy365.api.interfaces.controller.dto.out.BibleBookResponse;
import goj.holy365.api.interfaces.controller.dto.out.BibleVerseResponse;
import goj.holy365.common.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bible")
@Tag(name = "Bible", description = "Bible API")
public class BibleController {
	private final BibleFacade bibleFacade;

	@GetMapping("/verses")
	@Operation(summary = "fetch bible verses", description = "성경 구절을 조회합니다")
	public ApiResponse<List<BibleVerseResponse>> scanVerses(@Validated @ModelAttribute ScanBibleVersesRequest request) {
		return ApiResponse.success(bibleFacade.scanVerses(request.toFacadeDto()
		).stream().map(BibleVerseResponse::fromInfo).toList());
	}

	@GetMapping("/books")
	@Operation(summary = "fetch bible books", description = "성경 책 목록을 조회합니다")
	public ApiResponse<List<BibleBookResponse>> scanBooks(@Validated @ModelAttribute ScanBibleBooksRequest request) {
		return ApiResponse.success(bibleFacade.scanBooks(request.getVersionId()
		).stream().map(BibleBookResponse::fromInfo).toList());
	}

	@GetMapping("/chapters")
	@Operation(summary = "fetch bible book chapters", description = "성경 책 구절을 조회합니다")
	public ApiResponse<List<Integer>> scanChapters(@Validated @ModelAttribute ScanBibleChaptersRequest request) {
		return ApiResponse.success(bibleFacade.scanChapters(request.getVersionId(), request.getBookId()));
	}
}
