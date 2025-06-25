package automation.constants;

public class CT_HomePage {
	public static final String BEPTU_LINK = "(//a[@href = '/danh-muc/bep-tu'])[4]";
	public static final String BEPTU_BRAND_NAME = "//a[@href = '/danh-muc/bep-tu/%s']";
	public static final String MAYRUACHENBAT_BRAND_NAME = "//a[@href = '/danh-muc/may-rua-chen-bat/%s']";
	public static final String FIRST_PROD = "(//div[@class = 'flex flex-wrap product-list']//a)[1]";
	public static final String BUY_NOW_BTN =  "(//span[text() = 'Mua ngay']/parent::a)[1]";
	public static final String PAY_BTN = "//span[text() = 'Thanh toán']/parent::button";
	public static final String NAME_ERROR = "//small[normalize-space() = 'Họ và tên không hợp lệ']";
	public static final String PHONE_ERROR = "//small[normalize-space() = 'Số điện thoại không hợp lệ']";
	public static final String ADRESS_ERROR = "//small[normalize-space() = 'Địa chỉ không hợp lệ']";
	public static final String NAME_INPUT = "//input[@placeholder = 'Nhập họ và tên']";
	public static final String PHONE_INPUT = "//input[@placeholder = 'Nhập số điện thoại']";
	public static final String ADDRESS_INPUT = "//input[@placeholder = 'Nhập số nhà, tên đường, phường/ xã, quận/huyện, tỉnh/ thành phố']";
	public static final String BEPGAS_LINK = "//a[@href = '/danh-muc/bep-gas' and @class = 'menu-link']";
	public static final String BEPGAAM_LINK = "//a[text() = 'Bếp Gas Âm']";
	public static final String PROD_LIST = "//div[@class = 'flex flex-wrap product-list']//h4";
	public static final String ENG_COUNTRY = "england-1027";
	public static final String ENG_PROD = "(//div[@class = 'flex flex-wrap product-list']//a)[1]";
	public static final String MADE_BY = "(//span[contains(text(), 'Xuất xứ')])[1]//following-sibling::span";
	public static final String MENU_LINK = "//a[@class= 'menu-link' and contains(text(), '%s')]";
	public static final String PROD_PRICE = "//h3[text() = 'Mức giá']//following-sibling::div/div/span[contains(text(), '%s')]";
	public static final String COUNTRY_NAME = "//span[text() = '%s']";
	public static final String SO_BO = "//h3[text() = 'Số Bộ']//following-sibling::div/div/div/div/div//span[text() = '%s']";
}
