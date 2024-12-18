package com.sopt.carrot_server.app.domain.enums;

import com.sopt.carrot_server.global.common.code.FailureCode;
import com.sopt.carrot_server.global.common.exception.ProductException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum Category {

    DIGITAL_DEVICES("디지털기기"),
    FURNITURE_INTERIOR("가구/인테리어"),
    BABY_PRODUCTS("유아동"),
    WOMEN_CLOTHING("여성의류"),
    WOMEN_ACCESSORIES("여성잡화"),
    MENS_CLOTHING("남성패션/잡화"),
    HOME_APPLIANCES("생활가전"),
    HOME_KITCHEN("생활/주방"),
    SPORTS_LEISURE("스포츠/레저"),
    HOBBY_GAMES_MUSIC("취미/게임/음반"),
    BEAUTY_COSMETICS("뷰티/미용"),
    GROCERIES("식물"),
    FOOD("가공식품"),
    HEALTH_SUPPLEMENTS("건강기능식품"),
    PET_PRODUCTS("반려동물용품"),
    TICKETS_GIFT_CARDS("티켓/교환권"),
    BOOKS("도서"),
    CHILDREN_BOOKS("유아 도서"),
    OTHER_RELIGIOUS_ITEMS("기타 종교물품"),
    BUY("삽니다");

    private final String value;

    public static List<String> getValues() {
        return Arrays.stream(Category.values())
                .map(Category::getValue).toList();
    }

    public static String toKorean(String value) {
        // 주어진 value에 해당하는 영어 이름 찾기
        for (Category category : Category.values()) {
            if (category.name().equals(value)) {
                return category.getValue();
            }
        }
        return null; // 매칭되지 않으면 null 반환
    }

    public static String fromKoreanToEnglish(String koreanCategory){
        return Arrays.stream(Category.values()).filter(category -> category.value.equals(koreanCategory))
                .findFirst().orElseThrow(()-> new ProductException(FailureCode.INVALID_CATEGORY)).name();
    }
}
