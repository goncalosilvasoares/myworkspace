import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:great_places/models/place.dart';

class MapScreen extends StatefulWidget {
  final PlaceLocation initialLocation;
  final bool isReadOnly;

  MapScreen({
    this.initialLocation = const PlaceLocation(
        latitude: 2132131231.313123, longitude: 231231321.231213),
    this.isReadOnly = false,
  });

  @override
  _MapScreenState createState() => _MapScreenState();
}

class _MapScreenState extends State<MapScreen> {
  LatLng? _pickedPosition;

  void _selectPosition(LatLng pos) {
    setState(() {
      _pickedPosition = pos;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Select...'),
        actions: [
          if (widget.isReadOnly)
            IconButton(
              onPressed: _pickedPosition == null
                  ? null
                  : () {
                      Navigator.of(context).pop(_pickedPosition);
                    },
              icon: Icon(Icons.check),
            ),
        ],
      ),
      body: GoogleMap(
        initialCameraPosition: CameraPosition(
          target: LatLng(
            widget.initialLocation.latitude,
            widget.initialLocation.longitude,
          ),
          zoom: 13,
        ),
        onTap: widget.isReadOnly ? null : _selectPosition,
        markers: (_pickedPosition == null && !widget.isReadOnly)
            ? <Marker>[].toSet()
            : [
                Marker(
                  markerId: MarkerId('m1'),
                  position:
                      _pickedPosition ?? widget.initialLocation.toLagLng(),
                ),
              ].toSet(),
      ),
    );
  }
}
