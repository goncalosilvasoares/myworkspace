import 'dart:convert';

import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:http/http.dart' as http;

const GOOGLE_API_KEY = '';

class LocationUtil {
  static String generateLocationPreviewImage(
      {required double latitude, required double longitude}) {
    return 'url+$latitude,$longitude&API_KEY';
  }

  static Future<String> getAddressFrom(LatLng position) async {
    final url = 'url+$position.latitude,$position.longitude&API_KEY';
    final response = await http.get(Uri.parse(url));
    return jsonDecode(response.body)['results'][0]['formatted_address'];
  }
}
