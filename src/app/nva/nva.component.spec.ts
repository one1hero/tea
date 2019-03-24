import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NvaComponent } from './nva.component';

describe('NvaComponent', () => {
  let component: NvaComponent;
  let fixture: ComponentFixture<NvaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NvaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NvaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
