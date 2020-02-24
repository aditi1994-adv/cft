package com.cft.serviceImpl;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cft.model.Advertisement;
import com.cft.repo.AdvertisementRepo;
import com.cft.service.AdvertisementService;
import com.cft.util.MailSenderByThread2;
import com.cft.util.TimeConverter;


@Service
public class AdvertisementServiceImpl  implements AdvertisementService
{
	@Autowired
	private AdvertisementRepo  adRepo;


	/*
	@Override
	public Advertisement sendEmails(MultipartFile imgpath, Advertisement ad) {


		return null;
	}
	 */


	@Override
	public Advertisement sendEmails(MultipartFile imgpath, Advertisement ad, MultipartFile attachment) {
		Advertisement advertisement=new Advertisement();
		int count=0;
		try {
			List<String> strEmail =new ArrayList();
			String email="",name="";
			byte[] str= imgpath.getBytes();
			XSSFWorkbook workbook = new XSSFWorkbook(new ByteArrayInputStream(str));
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator itr = sheet.rowIterator();	
			itr.next();
			//	Iterator itr  =		ExcelRead.readExcel(imgpath);
			while (itr.hasNext()) {
				XSSFRow row = (XSSFRow) itr.next();

				Iterator cells = row.cellIterator();
				while (cells.hasNext()) {
					cells.next();
					Object obj = getCellValue((XSSFCell) row.getCell(1));
					try {
						name =obj != null ? obj.toString(): null;
						obj = getCellValue((XSSFCell) row.getCell(2));
						email =obj != null ? obj.toString(): null;
						
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				Advertisement getAdvertisement= new Advertisement();
				getAdvertisement.setAttachmentPath(TimeConverter.attachmentPath(attachment)==null?"":TimeConverter.attachmentPath(attachment));
				getAdvertisement.setUploadedEmailPath(TimeConverter.attachmentPath(attachment)==null?"":TimeConverter.attachmentPath(attachment));
				getAdvertisement.setSentOn(String.valueOf(System.currentTimeMillis()));
				getAdvertisement.setCompanyId(0);
				getAdvertisement.setCreaterType(4);
				
				//customer_email
				getAdvertisement.setBusinessSector(0);
				getAdvertisement.setCreatedBy(0);
				getAdvertisement.setCustomerEmail(email);
				getAdvertisement.setMessage(ad.getMessage().trim());
				getAdvertisement.setSubject(ad.getSubject());
				
				getAdvertisement.setDescriptionText("");
				advertisement =	adRepo.save(getAdvertisement);
				
				MailSenderByThread2 mailSenderByThread2= new MailSenderByThread2();
				mailSenderByThread2.subject=advertisement.getSubject();
				mailSenderByThread2.filename=advertisement.getAttachmentPath();
				mailSenderByThread2.msg=advertisement.getMessage();
				mailSenderByThread2.toMailId=email.trim();
				mailSenderByThread2.start();

			}
			/*System.out.println("AdvertisementServiceImpl.sendEmails()");
		for (int i = 0; i < strEmail.size(); i++) {
		}*/

			return advertisement;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}


	}

	private static Object getCellValue(Cell cell) {
		switch (cell.getCellTypeEnum()) {
		case BOOLEAN:
			System.out.print(cell.getBooleanCellValue());

			return cell.getBooleanCellValue();

		case STRING:
			System.out.print(cell.getRichStringCellValue().getString());
			return cell.getRichStringCellValue().getString();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				System.out.print(cell.getDateCellValue());
				return cell.getDateCellValue();
			} else {
				System.out.print(cell.getNumericCellValue());
				return cell.getNumericCellValue();
			}

		case FORMULA:
			System.out.print(cell.getCellFormula());
			return cell.getCellFormula();
		case BLANK:
			System.out.print("");
			return "";
		default:
			System.out.print("");
			return "";
		}

	}

}


