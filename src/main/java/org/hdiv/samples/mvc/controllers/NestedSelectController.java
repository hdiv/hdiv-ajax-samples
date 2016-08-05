package org.hdiv.samples.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hdiv.dataComposer.IDataComposer;
import org.hdiv.samples.mvc.bean.NestedSelectResult;
import org.hdiv.samples.mvc.bean.Town;
import org.hdiv.util.HDIVUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/nestedSelect")
public class NestedSelectController {

	@RequestMapping(method = RequestMethod.GET)
	public String prepareIndex(final Model model) {
		model.addAttribute("result", new NestedSelectResult());
		return "/nestedSelect/nestedSelect";
	}

	@RequestMapping(value = "/getTowns", method = RequestMethod.GET)
	public @ResponseBody List<Town> getTowns(final HttpServletRequest request, @RequestParam(value = "province") final String province) {

		List<Town> towns = new ArrayList<Town>();

		if (province.equals("Province1")) {
			towns.add(new Town("Province1Town1", "Province1Town1"));
			towns.add(new Town("Province1Town2", "Province1Town2"));
			towns.add(new Town("Province1Town3", "Province1Town3"));
			towns.add(new Town("Province1Town4", "Province1Town4"));
		}

		if (province.equals("Province2")) {
			towns.add(new Town("Province2Town1", "Province2Town1"));
			towns.add(new Town("Province2Town2", "Province2Town2"));
			towns.add(new Town("Province2Town3", "Province2Town3"));
			towns.add(new Town("Province2Town4", "Province2Town4"));
		}

		if (province.equals("Province3")) {
			towns.add(new Town("Province3Town1", "Province3Town1"));
			towns.add(new Town("Province3Town2", "Province3Town2"));
			towns.add(new Town("Province3Town3", "Province3Town3"));
			towns.add(new Town("Province3Town4", "Province3Town4"));
		}

		IDataComposer dataComposer = HDIVUtil.getDataComposer(request);
		for (Town town : towns) {
			String key = dataComposer.compose("town", town.getKey(), false);
			town.setKey(key);
		}

		return towns;
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody NestedSelectResult showSelected(@ModelAttribute final NestedSelectResult result) {

		System.out.println("Selected province: " + result.getProvince() + ", town: " + result.getTown());
		return result;
	}

}
